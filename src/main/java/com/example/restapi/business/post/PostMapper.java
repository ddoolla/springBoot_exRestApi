package com.example.restapi.business.post;

import com.example.restapi.business.post.dto.PostDto;
import com.example.restapi.business.post.dto.PostInfoDto;
import com.example.restapi.business.post.dto.request.PostCreateRequest;
import com.example.restapi.persistence.post.Post;
import com.example.restapi.persistence.post.record.PostInfoRecord;
import com.example.restapi.persistence.post.record.PostRecord;
import com.example.restapi.persistence.user.User;

public class PostMapper {

    public static PostDto toPostDto(PostRecord data) {
        return new PostDto(
                data.getId(),
                data.getTitle(),
                data.getContent(),
                data.getUser().getNickName()
        );
    }

    public static PostInfoDto toPostInfoDto(PostInfoRecord data) {
        return new PostInfoDto(
                data.getId(),
                data.getTitle(),
                data.getContent(),
                data.getCreatedAt(),
                data.getUser().getId(),
                data.getUser().getNickName()
        );
    }

    public static Post toEntity(PostCreateRequest request) {
        return new Post(
                request.getTitle(),
                request.getContent(),
                User.toTemp(request.getUserId())
        );
    }

}
