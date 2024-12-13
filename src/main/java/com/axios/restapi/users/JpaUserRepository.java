package com.axios.restapi.users;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface JpaUserRepository extends Repository<User, Long> {

    void save(User user);

    Optional<User> findById(Long id);
}
