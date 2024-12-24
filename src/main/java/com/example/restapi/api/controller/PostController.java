package com.example.restapi.api.controller;

import com.example.restapi.api.response.ApiResponse;
import com.example.restapi.business.post.PostService;
import com.example.restapi.business.post.dto.PostListDto;
import com.example.restapi.business.post.dto.request.PostCreateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<ApiResponse<PostListDto>> getAllPosts(@PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(new ApiResponse<>(postService.listPosts(pageable)));
    }


    @PostMapping
    public ResponseEntity<Void> createPost(@Valid @RequestBody PostCreateRequest request) {
        Long newId = postService.registerPost(request);
        return ResponseEntity.created(URI.create("/api/posts/" + newId)).build();
    }
}
