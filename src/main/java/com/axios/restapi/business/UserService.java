package com.axios.restapi.business;

import com.axios.restapi.business.dto.UserCreateDto;
import com.axios.restapi.business.dto.UserInfoDto;
import com.axios.restapi.business.dto.UserListDto;
import com.axios.restapi.business.dto.UserUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserListDto> listUsers(Pageable pageable);

    UserInfoDto getUserBy(Long id);

    Long registerUser(UserCreateDto data);

    void editUser(Long id, UserUpdateDto userUpdateDto);
}
