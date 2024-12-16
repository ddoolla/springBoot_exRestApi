package com.axios.restapi.business.dto;

import com.axios.restapi.persistence.entity.User;
import com.axios.restapi.shared.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreateDto {

    private String name;
    private Gender gender;
    private String hobby;

    public User toEntity() {
        return new User(name, gender, hobby);
    }
}
