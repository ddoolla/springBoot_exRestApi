package com.example.restapi.persistence.post;

import com.example.restapi.persistence.post.record.PostInfoRecord;
import com.example.restapi.persistence.post.record.PostRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PostRepository {

    Page<PostRecord> selectAllPosts(Pageable pageable);

    Optional<PostInfoRecord> selectPostBy(Long id);

    Long insertPost(Post post);
}
