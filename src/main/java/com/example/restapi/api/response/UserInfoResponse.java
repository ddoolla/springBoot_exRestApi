package com.example.restapi.api.response;

import com.example.restapi.business.dto.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoResponse {

    private UserInfoDto user;
}
