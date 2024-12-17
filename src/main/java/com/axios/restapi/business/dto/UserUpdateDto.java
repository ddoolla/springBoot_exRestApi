package com.axios.restapi.business.dto;

import com.axios.restapi.shared.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserUpdateDto {

    private String name;
    private Gender gender;
    private String hobby;

}
