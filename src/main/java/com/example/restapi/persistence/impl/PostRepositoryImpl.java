package com.example.restapi.persistence.impl;

import com.example.restapi.persistence.JpaPostRepository;
import com.example.restapi.persistence.PostRepository;
import com.example.restapi.persistence.entity.Post;
import com.example.restapi.persistence.record.PostListRecord;
import com.example.restapi.persistence.record.QPostListRecord;
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

import static com.example.restapi.persistence.entity.QPost.post;
import static com.example.restapi.persistence.entity.QUser.user;

@Transactional(readOnly = true)
@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final JpaPostRepository jpaPostRepository;
    private final JPAQueryFactory query;

    /* 조건 메서드 */
    private BooleanExpression notDelete() {
        return post.deletedAt.isNotNull()
                .and(user.deletedAt.isNotNull());
    }

    /* 쿼리 메서드 */
    @Override
    public Page<PostListRecord> selectAllPosts(Pageable pageable) {
        List<PostListRecord> content = query
                .select(new QPostListRecord(
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
