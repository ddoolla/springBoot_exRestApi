package com.example.restapi.shared.mapper;

import com.example.restapi.api.request.PostCreateRequest;
import com.example.restapi.business.dto.PostCreateDto;
import com.example.restapi.business.dto.PostListDto;
import com.example.restapi.persistence.entity.Post;
import com.example.restapi.persistence.entity.User;
import com.example.restapi.persistence.record.PostListRecord;

public class PostMapper {

    public static PostListDto toPostListDto(PostListRecord data) {
        return new PostListDto(
                data.getId(),
                data.getTitle(),
                data.getContent(),
                data.getUser().getName()
        );
    }
    public static PostCreateDto toPostCreateDto(PostCreateRequest request) {
        return new PostCreateDto(
                request.getUserId(),
                request.getTitle(),
                request.getContent()
        );
    }

    public static Post toEntity(PostCreateDto dto) {
        return new Post(
                dto.getTitle(),
                dto.getContent(),
                User.toTemp(dto.getUserId())
        );
    }

}
