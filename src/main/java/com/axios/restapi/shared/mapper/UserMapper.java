package com.axios.restapi.shared.mapper;

import com.axios.restapi.business.dto.UserCreateDto;
import com.axios.restapi.business.dto.UserInfoDto;
import com.axios.restapi.business.dto.UserListDto;
import com.axios.restapi.persistence.entity.User;
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

    public static UserInfoDto toUserInfoDto(User user) {
        return new UserInfoDto(
                user.getId(),
                user.getName(),
                user.getGender(),
                user.getHobby(),
                user.getCreatedAt()
        );
    }

    public static User toEntity(UserCreateDto dto) {
        return new User(
                dto.getName(),
                dto.getGender(),
                dto.getHobby()
        );
    }
}
