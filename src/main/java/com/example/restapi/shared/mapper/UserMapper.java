package com.example.restapi.shared.mapper;

import com.example.restapi.api.request.UserCreateRequest;
import com.example.restapi.api.request.UserUpdateRequest;
import com.example.restapi.business.dto.UserCreateDto;
import com.example.restapi.business.dto.UserInfoDto;
import com.example.restapi.business.dto.UserListDto;
import com.example.restapi.business.dto.UserUpdateDto;
import com.example.restapi.persistence.entity.User;
import com.example.restapi.persistence.record.UserInfoRecord;
import com.example.restapi.persistence.record.UserListRecord;
import com.example.restapi.shared.util.StringFormatUtil;

public class UserMapper {

    public static UserListDto toUserListDto(UserListRecord data) {
        return new UserListDto(
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

    public static UserCreateDto toUserCreateDto(UserCreateRequest request) {
        return new UserCreateDto(
                request.getName(),
                request.getGender(),
                request.getHobby()
        );
    }

    public static UserUpdateDto toUserUpdateDto(UserUpdateRequest request) {
        return new UserUpdateDto(
                request.getName(),
                request.getGender(),
                request.getHobby()
        );
    }

    public static User toEntity(UserCreateDto dto) {
        return new User(
                dto.getName(),
                dto.getGender(),
                dto.getHobby()
        );
    }

    public static User toEntity(UserUpdateDto dto) {
        return new User(
                dto.getName(),
                dto.getGender(),
                dto.getHobby()
        );
    }
}
