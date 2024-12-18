package com.axios.restapi.persistence.impl;

import com.axios.restapi.persistence.JpaUserRepository;
import com.axios.restapi.persistence.UserRepository;
import com.axios.restapi.persistence.entity.User;
import com.axios.restapi.persistence.record.QUserInfoRecord;
import com.axios.restapi.persistence.record.QUserListRecord;
import com.axios.restapi.persistence.record.UserInfoRecord;
import com.axios.restapi.persistence.record.UserListRecord;
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

import static com.axios.restapi.persistence.entity.QUser.user;

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

    /* 비즈니스 메서드 */
    @Override
    public Page<UserListRecord> selectAllUsers(Pageable pageable) {
        List<UserListRecord> content = query
                .select(new QUserListRecord(
                        user.id,
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
                .select(user.id)
                .from(user)
                .where(notDelete(), idEq(id))
                .fetchOne() != null;
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
    public void updateUser(Long id, User userEntity) {
        query.update(user)
                .set(user.name, userEntity.getName())
                .set(user.gender, userEntity.getGender())
                .set(user.hobby, userEntity.getHobby())
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
