package com.axios.restapi.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCreateDto {

    private Long userId;
    private String title;
    private String content;

}
