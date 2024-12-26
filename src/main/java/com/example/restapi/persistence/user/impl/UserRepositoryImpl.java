package com.example.restapi.persistence.user.impl;

import com.example.restapi.persistence.user.JpaUserRepository;
import com.example.restapi.persistence.user.User;
import com.example.restapi.persistence.user.UserRepository;
import com.example.restapi.persistence.user.record.QUserInfoRecord;
import com.example.restapi.persistence.user.record.QUserRecord;
import com.example.restapi.persistence.user.record.UserInfoRecord;
import com.example.restapi.persistence.user.record.UserRecord;
import com.example.restapi.shared.enums.Gender;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.restapi.persistence.user.QUser.user;

@Transactional(readOnly = true)
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final JPAQueryFactory query;

    /* 조건 메서드 */
    private BooleanExpression notDelete() {
        return user.deletedAt.isNull();
    }

    private BooleanExpression idEq(Long id) {
        return user.id.eq(id);
    }

    /* 쿼리 메서드 */
    @Override
    public Page<UserRecord> selectAllUsers(Pageable pageable) {
        List<UserRecord> content = query
                .select(new QUserRecord(
                        user.id,
                        user.nickName,
                        user.name,
                        user.gender,
                        user.hobby,
                        user.createdAt
                )).from(user)
                .where(notDelete())
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();

        JPAQuery<Long> count = query
                .select(user.count())
                .from(user)
                .where(notDelete());

        return PageableExecutionUtils.getPage(content, pageable, count::fetchFirst);
    }

    @Override
    public Optional<UserInfoRecord> selectUserBy(Long id) {
        return Optional.ofNullable(query
                .select(new QUserInfoRecord(
                        user.id,
                        user.nickName,
                        user.name,
                        user.gender,
                        user.hobby,
                        user.createdAt
                )).from(user)
                .where(notDelete(), idEq(id))
                .fetchOne()
        );
    }

    @Override
    public boolean existsUserBy(Long id) {
        return query
                .selectOne()
                .from(user)
                .where(notDelete(), idEq(id))
                .fetchFirst() != null;
    }

    @Override
    public User getProxyUserBy(Long id) {
        return jpaUserRepository.getReferenceById(id);
    }

    @Transactional
    @Override
    public Long insertUser(User userEntity) {
        return jpaUserRepository.save(userEntity).getId();
    }

    @Transactional
    @Override
    public void updateUser(Long id,
                           String password,
                           String name,
                           Gender gender,
                           String hobby) {
        query.update(user)
                .set(user.password, password)
                .set(user.name, name)
                .set(user.gender, gender)
                .set(user.hobby, hobby)
                .set(user.updatedAt, LocalDateTime.now())
                .where(idEq(id))
                .execute();
    }

    @Transactional
    @Override
    public void deleteUserBy(Long id) {
        query.update(user)
                .set(user.deletedAt, LocalDateTime.now())
                .where(idEq(id))
                .execute();
    }

}
