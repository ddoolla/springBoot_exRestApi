package com.axios.restapi.persistence;

import com.axios.restapi.persistence.record.UserListRecord;
import com.axios.restapi.persistence.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserRepository {

    Page<UserListRecord> selectAllUsers(Pageable pageable);

    Optional<User> selectUserBy(Long id);

    boolean existsUserBy(Long id);

    Long insertUser(User user);

    void updateUser(Long id, User user);

}
