package com.example.restapi.business.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserListDto {

    private List<UserDto> users;
    private Long count;
    private Pageable pageable;

}
