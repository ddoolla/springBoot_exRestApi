package com.axios.restapi.persistence.user;

import com.axios.restapi.persistence.user.dto.QUserListDto;
import com.axios.restapi.persistence.user.dto.UserListDto;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.axios.restapi.persistence.user.QUser.user;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final JPAQueryFactory query;

    @Override
    public Page<UserListDto> selectAllUsers(Pageable pageable) {
        List<UserListDto> content = query
                .select(new QUserListDto(
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

    @Override
    public Long insertUser(User user) {
        return jpaUserRepository.save(user).getId();
    }
}
