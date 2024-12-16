package com.axios.restapi.persistence.user.dto;

import com.axios.restapi.persistence.user.enums.Gender;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserListDto {

    private final Long id;
    private final String name;
    private final Gender gender;
    private final String hobby;
    private final LocalDateTime createdAt;

    @QueryProjection
    public UserListDto(Long id,
                       String name,
                       Gender gender,
                       String hobby,
                       LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.hobby = hobby;
        this.createdAt = createdAt;
    }
}
