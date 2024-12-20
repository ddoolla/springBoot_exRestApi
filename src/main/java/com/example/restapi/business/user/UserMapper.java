package com.example.restapi.business.user;

import com.example.restapi.business.user.dto.UserDto;
import com.example.restapi.business.user.dto.UserInfoDto;
import com.example.restapi.business.user.dto.request.UserCreateRequest;
import com.example.restapi.business.user.dto.request.UserUpdateRequest;
import com.example.restapi.persistence.user.User;
import com.example.restapi.persistence.user.record.UserInfoRecord;
import com.example.restapi.persistence.user.record.UserRecord;
import com.example.restapi.shared.util.StringFormatUtil;

public class UserMapper {

    public static UserDto toUserDto(UserRecord data) {
        return new UserDto(
                data.getId(),
                data.getName(),
                data.getGender(),
                data.getHobby(),
                StringFormatUtil.formatDateTime(data.getCreatedAt(), "yyyy-MM-dd HH:mm:ss")
        );
    }

    public static UserInfoDto toUserInfoDto(UserInfoRecord data) {
        return new UserInfoDto(
                data.getId(),
                data.getName(),
                data.getGender(),
                data.getHobby(),
                StringFormatUtil.formatDateTime(data.getCreatedAt(), "yyyy-MM-dd HH:mm:ss")
        );
    }

    public static User toEntity(UserCreateRequest request) {
        return new User(
                request.getName(),
                request.getGender(),
                request.getHobby()
        );
    }

    public static User toEntity(UserUpdateRequest request) {
        return new User(
                request.getName(),
                request.getGender(),
                request.getHobby()
        );
    }
}
