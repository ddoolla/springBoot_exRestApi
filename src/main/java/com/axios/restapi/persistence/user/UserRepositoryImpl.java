package com.axios.restapi.persistence.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public Long insertUser(User user) {
        return jpaUserRepository.save(user).getId();
    }
}
