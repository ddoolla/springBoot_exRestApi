package com.example.restapi.persistence.post.impl;

import com.example.restapi.persistence.post.JpaPostRepository;
import com.example.restapi.persistence.post.Post;
import com.example.restapi.persistence.post.PostRepository;
import com.example.restapi.persistence.post.record.PostInfoRecord;
import com.example.restapi.persistence.post.record.PostRecord;
import com.example.restapi.persistence.post.record.QPostInfoRecord;
import com.example.restapi.persistence.post.record.QPostRecord;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.example.restapi.persistence.post.QPost.post;
import static com.example.restapi.persistence.user.QUser.user;

@Transactional(readOnly = true)
@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final JpaPostRepository jpaPostRepository;
    private final JPAQueryFactory query;

    /* 조건 메서드 */
    private BooleanExpression notDelete() {
        return post.deletedAt.isNull()
                .and(user.deletedAt.isNull());
    }

    private BooleanExpression eqId(Long id) {
        return post.id.eq(id);
    }

    /* 쿼리 메서드 */
    @Override
    public Page<PostRecord> selectAllPosts(Pageable pageable) {
        List<PostRecord> content = query
                .select(new QPostRecord(
                        post.id,
                        post.title,
                        post.content,
                        user.nickName
                )).from(post)
                .innerJoin(user).on(post.user.id.eq(user.id))
                .where(notDelete())
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();

        JPAQuery<Long> count = query
                .select(post.count())
                .from(post)
                .innerJoin(user).on(post.user.id.eq(user.id))
                .where(notDelete());

        return PageableExecutionUtils.getPage(content, pageable, count::fetchFirst);
    }

    @Override
    public Optional<PostInfoRecord> selectPostBy(Long id) {
        return Optional.ofNullable(query
                .select(new QPostInfoRecord(
                        post.id,
                        post.title,
                        post.content,
                        post.createdAt,
                        user.id,
                        user.nickName
                )).from(post)
                .innerJoin(user).on(post.user.id.eq(user.id))
                .where(notDelete(), eqId(id))
                .fetchOne()
        );
    }

    @Transactional
    @Override
    public Long insertPost(Post post) {
        return jpaPostRepository.save(post).getId();
    }
}
