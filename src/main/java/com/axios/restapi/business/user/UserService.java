package com.axios.restapi.business.user;

import com.axios.restapi.business.user.data.CreateUserData;
import com.axios.restapi.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long registerUser(CreateUserData data) {
        return userRepository.insertUser(data.toEntity());
    }
}
