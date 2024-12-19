package com.example.restapi.business.impl;

import com.example.restapi.business.PostService;
import com.example.restapi.business.component.ExistenceValidator;
import com.example.restapi.business.dto.PostCreateDto;
import com.example.restapi.business.dto.PostListDto;
import com.example.restapi.persistence.PostRepository;
import com.example.restapi.shared.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ExistenceValidator validator;

    @Override
    public Page<PostListDto> listPosts(Pageable pageable) {
        return postRepository.selectAllPosts(pageable).map(PostMapper::toPostListDto);
    }

    @Override
    public Long registerPost(PostCreateDto dto) {
        validator.validateUserExists(dto.getUserId());
        return postRepository.createPost(PostMapper.toEntity(dto));
    }
}
