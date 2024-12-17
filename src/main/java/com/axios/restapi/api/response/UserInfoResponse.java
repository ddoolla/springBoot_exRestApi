package com.axios.restapi.api.response;

import com.axios.restapi.business.dto.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoResponse {

    private UserInfoDto user;
}
