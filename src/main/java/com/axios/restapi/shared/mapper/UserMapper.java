package com.axios.restapi.shared.mapper;

import com.axios.restapi.business.dto.UserListDto;
import com.axios.restapi.persistence.record.UserListRecord;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserListDto toUserListDto(UserListRecord data) {
        return new UserListDto(
                data.getId(),
                data.getName(),
                data.getGender(),
                data.getHobby(),
                data.getCreatedAt()
        );
    }
}
