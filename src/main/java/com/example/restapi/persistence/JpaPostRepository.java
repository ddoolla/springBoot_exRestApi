package com.example.restapi.persistence;

import com.example.restapi.persistence.entity.Post;
import org.springframework.data.repository.Repository;

public interface JpaPostRepository extends Repository<Post, Long> {

    Post save(Post post);
}
