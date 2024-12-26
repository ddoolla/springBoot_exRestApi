package com.example.restapi.business.post.impl;

import com.example.restapi.business.component.ExistenceValidator;
import com.example.restapi.business.exception.NotFoundException;
import com.example.restapi.business.post.PostMapper;
import com.example.restapi.business.post.PostService;
import com.example.restapi.business.post.dto.PostDto;
import com.example.restapi.business.post.dto.PostInfoDto;
import com.example.restapi.business.post.dto.PostListDto;
import com.example.restapi.business.post.dto.request.PostCreateRequest;
import com.example.restapi.business.post.dto.request.PostUpdateRequest;
import com.example.restapi.persistence.post.PostRepository;
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
    public PostListDto listPosts(Pageable pageable) {
        Page<PostDto> postPages = postRepository.selectAllPosts(pageable).map(PostMapper::toPostDto);
        return new PostListDto(
                postPages.getContent(),
                postPages.getTotalElements(),
                postPages.getPageable()
        );
    }

    @Override
    public PostInfoDto getPostById(Long id) {
        return postRepository.selectPostBy(id).map(PostMapper::toPostInfoDto)
                .orElseThrow(() -> new NotFoundException("Post Not Found [Id: " + id + "]"));
    }

    @Override
    public Long registerPost(PostCreateRequest request) {
        validator.validateUser(request.getUserId());
        return postRepository.insertPost(PostMapper.toEntity(request));
    }

    @Override
    public void editPost(Long id, PostUpdateRequest request) {
        validator.validatePost(id);
        postRepository.updatePostBy(id, request.getTitle(), request.getContent());
    }

    @Override
    public void removePost(Long id) {
        validator.validatePost(id);
        postRepository.deletePostBy(id);
    }

}
