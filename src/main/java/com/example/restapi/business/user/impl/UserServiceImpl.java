package com.example.restapi.business.user.impl;

import com.example.restapi.business.component.ExistenceValidator;
import com.example.restapi.business.exception.NotFoundException;
import com.example.restapi.business.user.UserMapper;
import com.example.restapi.business.user.UserService;
import com.example.restapi.business.user.dto.UserDto;
import com.example.restapi.business.user.dto.UserInfoDto;
import com.example.restapi.business.user.dto.UserListDto;
import com.example.restapi.business.user.dto.request.UserCreateRequest;
import com.example.restapi.business.user.dto.request.UserUpdateRequest;
import com.example.restapi.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ExistenceValidator validator;

    @Override
    public UserListDto listUsers(Pageable pageable) {
        Page<UserDto> userPages = userRepository.selectAllUsers(pageable)
                .map(UserMapper::toUserDto);
        return new UserListDto(
                userPages.getContent(),
                userPages.getTotalElements(),
                userPages.getPageable()
        );
    }

    @Override
    public UserInfoDto getUserBy(Long id) {
        return userRepository.selectUserBy(id)
                .map(UserMapper::toUserInfoDto)
                .orElseThrow(() -> new NotFoundException("User Not Found [Id: " + id + "]"));
    }

    @Override
    public Long registerUser(UserCreateRequest request) {
        return userRepository.insertUser(UserMapper.toEntity(request));

    }

    @Override
    public void editUser(Long id, UserUpdateRequest request) {
        validator.validateUser(id);
        userRepository.updateUser(
                id,
                request.getPassword(),
                request.getName(),
                request.getGender(),
                request.getHobby()
        );
    }

    @Override
    public void removeUserBy(Long id) {
        validator.validateUser(id);
        userRepository.deleteUserBy(id);
    }


}
