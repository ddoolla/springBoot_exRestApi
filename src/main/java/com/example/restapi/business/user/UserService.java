package com.example.restapi.business.user;

import com.example.restapi.business.user.dto.UserInfoDto;
import com.example.restapi.business.user.dto.UserListDto;
import com.example.restapi.business.user.dto.request.UserCreateRequest;
import com.example.restapi.business.user.dto.request.UserUpdateRequest;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserListDto listUsers(Pageable pageable);

    UserInfoDto getUserBy(Long id);

    Long registerUser(UserCreateRequest request);

    void editUser(Long id, UserUpdateRequest request);

    void removeUserBy(Long id);
}
