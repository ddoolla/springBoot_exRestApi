package com.example.restapi.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class PostListDto {

    private final Long id;
    private final String title;
    private final String content;
    private final UserData user;

    public PostListDto(Long id,
                       String title,
                       String content,
                       String userName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = new UserData(userName);
    }

    @Getter
    @AllArgsConstructor
    static class UserData {
        private String name;
    }
}
