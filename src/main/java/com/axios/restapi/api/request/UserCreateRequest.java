package com.axios.restapi.api.request;

import com.axios.restapi.business.dto.UserCreateDto;
import com.axios.restapi.shared.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreateRequest {

    private String name;
    private Gender gender;
    private String hobby;

    public UserCreateDto toData() {
        return new UserCreateDto(name, gender, hobby);
    }
}
