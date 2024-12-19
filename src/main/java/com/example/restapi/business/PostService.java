package com.example.restapi.business;

import com.example.restapi.business.dto.PostCreateDto;
import com.example.restapi.business.dto.PostListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    Page<PostListDto> listPosts(Pageable pageable);

    Long registerPost(PostCreateDto dto);
}
