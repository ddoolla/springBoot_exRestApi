package com.axios.restapi.shared.mapper;

import com.axios.restapi.api.request.UserCreateRequest;
import com.axios.restapi.api.request.UserUpdateRequest;
import com.axios.restapi.business.dto.UserCreateDto;
import com.axios.restapi.business.dto.UserInfoDto;
import com.axios.restapi.business.dto.UserListDto;
import com.axios.restapi.business.dto.UserUpdateDto;
import com.axios.restapi.persistence.entity.User;
import com.axios.restapi.persistence.record.UserInfoRecord;
import com.axios.restapi.persistence.record.UserListRecord;

public class UserMapper {

    public static UserListDto toUserListDto(UserListRecord data) {
        return new UserListDto(
                data.getId(),
                data.getName(),
                data.getGender(),
                data.getHobby(),
                data.getCreatedAt()
        );
    }

    public static UserInfoDto toUserInfoDto(UserInfoRecord data) {
        return new UserInfoDto(
                data.getId(),
                data.getName(),
                data.getGender(),
                data.getHobby(),
                data.getCreatedAt()
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
