package com.axios.restapi.api;

import com.axios.restapi.api.request.PostCreateRequest;
import com.axios.restapi.business.PostService;
import com.axios.restapi.shared.mapper.PostMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(@Valid @RequestBody PostCreateRequest request) {
        Long newId = postService.registerPost(PostMapper.toPostCreateDto(request));
        return ResponseEntity.created(URI.create("/api/posts/" + newId)).build();
    }
}
