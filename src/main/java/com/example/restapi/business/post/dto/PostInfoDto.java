package com.example.restapi.business.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostInfoDto {

    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final UserData user;

    public PostInfoDto(Long id,
                          String title,
                          String content,
                          LocalDateTime createdAt,
                          Long userId,
                          String userNickName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.user = new UserData(userId, userNickName);
    }

    @Getter
    @AllArgsConstructor
    public static class UserData {
        private Long id;
        private String nickName;
    }

}
