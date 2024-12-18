package com.axios.restapi.persistence;

import com.axios.restapi.persistence.entity.Post;

public interface PostRepository {

    Long createPost(Post post);
}
