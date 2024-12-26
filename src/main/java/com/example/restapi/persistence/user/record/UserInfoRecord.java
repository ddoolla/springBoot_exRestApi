package com.example.restapi.persistence.user.record;

import com.example.restapi.shared.enums.Gender;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserInfoRecord {

    private final Long id;
    private final String nickName;
    private final String name;
    private final Gender gender;
    private final String hobby;
    private final LocalDateTime createdAt;

    @QueryProjection
    public UserInfoRecord(Long id,
                          String nickName,
                          String name,
                          Gender gender,
                          String hobby,
                          LocalDateTime createdAt) {
        this.id = id;
        this.nickName = nickName;
        this.name = name;
        this.gender = gender;
        this.hobby = hobby;
        this.createdAt = createdAt;
    }
}
