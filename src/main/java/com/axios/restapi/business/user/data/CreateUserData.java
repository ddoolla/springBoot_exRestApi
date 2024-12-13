package com.axios.restapi.business.user.data;

import com.axios.restapi.persistence.user.User;
import com.axios.restapi.persistence.user.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserData {

    private String name;
    private Gender gender;
    private String hobby;

    public User toEntity() {
        return new User(name, gender, hobby);
    }
}
