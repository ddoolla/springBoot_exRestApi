package com.axios.restapi.persistence;

import com.axios.restapi.persistence.entity.Post;
import org.springframework.data.repository.Repository;

public interface JpaPostRepository extends Repository<Post, Long> {

    Post save(Post post);
}
