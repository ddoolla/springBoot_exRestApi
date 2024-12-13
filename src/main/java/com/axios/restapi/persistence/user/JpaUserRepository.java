package com.axios.restapi.persistence.user;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface JpaUserRepository extends Repository<User, Long> {

    User save(User user);

    Optional<User> findById(Long id);
}
