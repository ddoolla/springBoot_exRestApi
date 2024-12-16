package com.axios.restapi.business.impl;

import com.axios.restapi.business.UserService;
import com.axios.restapi.business.dto.UserCreateDto;
import com.axios.restapi.persistence.UserRepository;
import com.axios.restapi.persistence.record.UserListRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public Page<UserListRecord> listUsers(Pageable pageable) {
        return userRepository.selectAllUsers(pageable);
    }

    public Long registerUser(UserCreateDto data) {
        return userRepository.insertUser(data.toEntity());
    }

}
