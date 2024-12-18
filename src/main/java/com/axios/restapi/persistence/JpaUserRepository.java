package com.axios.restapi.persistence;

import com.axios.restapi.persistence.entity.User;
import org.springframework.data.repository.Repository;


public interface JpaUserRepository extends Repository<User, Long> {

    User save(User user);

    User getReferenceById(Long id);
}
