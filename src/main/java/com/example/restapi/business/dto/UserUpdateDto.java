package com.example.restapi.business.dto;

import com.example.restapi.shared.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserUpdateDto {

    private String name;
    private Gender gender;
    private String hobby;

}
