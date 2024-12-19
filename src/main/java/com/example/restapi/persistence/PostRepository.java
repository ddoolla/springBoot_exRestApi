package com.example.restapi.persistence;

import com.example.restapi.persistence.entity.Post;
import com.example.restapi.persistence.record.PostListRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepository {

    Page<PostListRecord> selectAllPosts(Pageable pageable);

    Long createPost(Post post);
}
