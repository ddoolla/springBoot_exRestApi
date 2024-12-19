package com.example.restapi.business;

import com.example.restapi.business.dto.UserCreateDto;
import com.example.restapi.business.dto.UserInfoDto;
import com.example.restapi.business.dto.UserListDto;
import com.example.restapi.business.dto.UserUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserListDto> listUsers(Pageable pageable);

    UserInfoDto getUserBy(Long id);

    Long registerUser(UserCreateDto data);

    void editUser(Long id, UserUpdateDto userUpdateDto);

    void removeUserBy(Long id);
}
