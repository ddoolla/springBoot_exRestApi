package com.axios.restapi.business.dto;

import com.axios.restapi.shared.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserListDto {
    private Long id;
    private String name;
    private Gender gender;
    private String hobby;
    private String createdAt;
}
