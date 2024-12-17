package com.axios.restapi.api.request;

import com.axios.restapi.business.dto.UserCreateDto;
import com.axios.restapi.shared.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private Gender gender;

    @NotBlank
    private String hobby;

    public UserCreateDto toDto() {
        return new UserCreateDto(name, gender, hobby);
    }
}
