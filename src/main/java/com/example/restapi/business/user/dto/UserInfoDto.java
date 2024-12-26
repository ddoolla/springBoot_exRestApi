package com.example.restapi.business.user.dto;

import com.example.restapi.shared.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoDto {

    private Long id;
    private String nickName;
    private String name;
    private Gender gender;
    private String hobby;
    private String createdAt;

}
