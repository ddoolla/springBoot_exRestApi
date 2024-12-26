package com.example.restapi.business.post;

import com.example.restapi.business.post.dto.PostInfoDto;
import com.example.restapi.business.post.dto.PostListDto;
import com.example.restapi.business.post.dto.request.PostCreateRequest;
import org.springframework.data.domain.Pageable;

public interface PostService {

    PostListDto listPosts(Pageable pageable);

    PostInfoDto getPostById(Long id);

    Long registerPost(PostCreateRequest request);
}
