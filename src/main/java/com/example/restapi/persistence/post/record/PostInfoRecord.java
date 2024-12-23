package com.example.restapi.persistence.post.record;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostInfoRecord {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;


}
