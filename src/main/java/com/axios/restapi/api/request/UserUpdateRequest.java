package com.axios.restapi.api.request;

import com.axios.restapi.shared.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserUpdateRequest {

    @NotBlank
    private String name;

    @NotNull
    private Gender gender;

    @NotBlank
    private String hobby;
}