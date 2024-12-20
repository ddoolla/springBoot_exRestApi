package com.example.restapi.persistence.post;

import org.springframework.data.repository.Repository;

public interface JpaPostRepository extends Repository<Post, Long> {

    Post save(Post post);
}
