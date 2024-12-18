package com.axios.restapi.business.impl;

import com.axios.restapi.business.PostService;
import com.axios.restapi.business.component.ExistenceValidator;
import com.axios.restapi.business.dto.PostCreateDto;
import com.axios.restapi.persistence.PostRepository;
import com.axios.restapi.shared.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ExistenceValidator validator;

    @Override
    public Long registerPost(PostCreateDto dto) {
        validator.validateUserExists(dto.getUserId());
        return postRepository.createPost(PostMapper.toEntity(dto));
    }
}
