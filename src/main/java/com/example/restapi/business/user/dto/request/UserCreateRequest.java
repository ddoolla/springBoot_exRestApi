package com.example.restapi.business.user.dto.request;

import com.example.restapi.shared.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreateRequest {

    @NotBlank
    private String nickName;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotNull
    private Gender gender;

    @NotBlank
    private String hobby;

}
