package com.axios.restapi.api.user.request;

import com.axios.restapi.business.user.data.UserCreateData;
import com.axios.restapi.persistence.user.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreateRequest {

    private String name;
    private Gender gender;
    private String hobby;

    public UserCreateData toData() {
        return new UserCreateData(name, gender, hobby);
    }
}
