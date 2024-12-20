package com.example.restapi.persistence.post.record;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class PostRecord {

    private final Long id;
    private final String title;
    private final String content;
    private final UserData user;

    @QueryProjection
    public PostRecord(Long id,
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
    public static class UserData {
        private final String name;
    }
}
