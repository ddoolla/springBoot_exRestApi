package com.axios.restapi.persistence.impl;

import com.axios.restapi.persistence.JpaUserRepository;
import com.axios.restapi.persistence.entity.User;
import com.axios.restapi.persistence.UserRepository;
import com.axios.restapi.persistence.record.QUserListRecord;
import com.axios.restapi.persistence.record.UserListRecord;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.axios.restapi.persistence.entity.QUser.user;

@Transactional(readOnly = true)
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final JPAQueryFactory query;

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
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();

        JPAQuery<Long> count = query
                .select(user.count())
                .from(user);

        return PageableExecutionUtils.getPage(content, pageable, count::fetchFirst);
    }

    @Transactional
    @Override
    public Long insertUser(User user) {
        return jpaUserRepository.save(user).getId();
    }
}
