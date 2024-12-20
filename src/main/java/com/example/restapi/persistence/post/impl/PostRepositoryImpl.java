package com.example.restapi.persistence.post.impl;

import com.example.restapi.persistence.post.JpaPostRepository;
import com.example.restapi.persistence.post.Post;
import com.example.restapi.persistence.post.PostRepository;
import com.example.restapi.persistence.post.record.PostRecord;
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

    /* 쿼리 메서드 */
    @Override
    public Page<PostRecord> selectAllPosts(Pageable pageable) {
        List<PostRecord> content = query
                .select(new QPostRecord(
                        post.id,
                        post.title,
                        post.content,
                        user.name
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

    @Transactional
    @Override
    public Long createPost(Post post) {
        return jpaPostRepository.save(post).getId();
    }
}
