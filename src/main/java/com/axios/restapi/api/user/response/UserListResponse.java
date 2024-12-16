package com.axios.restapi.api.user.response;

import com.axios.restapi.persistence.user.dto.UserListDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserListResponse {

    private Page<UserListDto> users;

}
