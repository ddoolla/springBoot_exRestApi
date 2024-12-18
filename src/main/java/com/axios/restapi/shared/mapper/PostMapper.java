package com.axios.restapi.shared.mapper;

import com.axios.restapi.api.request.PostCreateRequest;
import com.axios.restapi.business.dto.PostCreateDto;
import com.axios.restapi.persistence.entity.Post;
import com.axios.restapi.persistence.entity.User;

public class PostMapper {

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
