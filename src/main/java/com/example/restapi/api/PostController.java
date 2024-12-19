package com.example.restapi.api;

import com.example.restapi.api.request.PostCreateRequest;
import com.example.restapi.api.response.PostListResponse;
import com.example.restapi.business.PostService;
import com.example.restapi.shared.mapper.PostMapper;
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
    public ResponseEntity<PostListResponse> getAllPosts(@PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(new PostListResponse(postService.listPosts(pageable)));

    }

    @PostMapping
    public ResponseEntity<Void> createPost(@Valid @RequestBody PostCreateRequest request) {
        Long newId = postService.registerPost(PostMapper.toPostCreateDto(request));
        return ResponseEntity.created(URI.create("/api/posts/" + newId)).build();
    }
}
