package com.axios.restapi.business.user;

import com.axios.restapi.business.user.data.UserCreateData;
import com.axios.restapi.persistence.user.UserRepository;
import com.axios.restapi.persistence.user.dto.UserListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Page<UserListDto> listUsers(Pageable pageable) {
        return userRepository.selectAllUsers(pageable);
    }

    public Long registerUser(UserCreateData data) {
        return userRepository.insertUser(data.toEntity());
    }

}
