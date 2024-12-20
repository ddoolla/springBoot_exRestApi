package com.example.restapi.persistence.post;

import com.example.restapi.persistence.post.record.PostRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepository {

    Page<PostRecord> selectAllPosts(Pageable pageable);

    Long createPost(Post post);
}
