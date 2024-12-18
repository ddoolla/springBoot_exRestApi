package com.axios.restapi.persistence.impl;

import com.axios.restapi.persistence.JpaPostRepository;
import com.axios.restapi.persistence.PostRepository;
import com.axios.restapi.persistence.entity.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final JpaPostRepository jpaPostRepository;
    private final JPAQueryFactory query;

    @Transactional
    @Override
    public Long createPost(Post post) {
        return jpaPostRepository.save(post).getId();
    }
}
