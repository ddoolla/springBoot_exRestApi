package com.axios.restapi.business.impl;

import com.axios.restapi.business.UserService;
import com.axios.restapi.business.dto.UserCreateDto;
import com.axios.restapi.business.dto.UserListDto;
import com.axios.restapi.persistence.UserRepository;
import com.axios.restapi.shared.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Page<UserListDto> listUsers(Pageable pageable) {
        return userRepository.selectAllUsers(pageable).map(userMapper::toUserListDto);
    }

    public Long registerUser(UserCreateDto data) {
        return userRepository.insertUser(data.toEntity());
    }

}
