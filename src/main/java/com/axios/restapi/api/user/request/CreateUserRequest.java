package com.axios.restapi.api.user.request;

import com.axios.restapi.business.user.data.CreateUserData;
import com.axios.restapi.persistence.user.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserRequest {

    private String name;
    private Gender gender;
    private String hobby;

    public CreateUserData toData() {
        return new CreateUserData(name, gender, hobby);
    }
}
