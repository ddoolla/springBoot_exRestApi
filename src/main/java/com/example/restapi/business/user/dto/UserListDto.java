package com.example.restapi.business.user.dto;

import com.example.restapi.shared.util.PaginationUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserListDto {

    private List<UserDto> users;
    private Long count;
    private PaginationUtil pagination;

}
