package com.example.restapi.persistence.user;

import org.springframework.data.repository.Repository;


public interface JpaUserRepository extends Repository<User, Long> {

    User save(User user);

    User getReferenceById(Long id);
}
