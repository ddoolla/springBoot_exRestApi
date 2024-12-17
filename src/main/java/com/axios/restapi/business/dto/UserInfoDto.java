package com.axios.restapi.business.dto;

import com.axios.restapi.shared.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserInfoDto {

    private Long id;
    private String name;
    private Gender gender;
    private String hobby;
    private LocalDateTime createdAt;

}
