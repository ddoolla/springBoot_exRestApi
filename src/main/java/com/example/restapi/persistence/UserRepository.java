package com.example.restapi.persistence;

import com.example.restapi.persistence.entity.User;
import com.example.restapi.persistence.record.UserInfoRecord;
import com.example.restapi.persistence.record.UserListRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserRepository {

    Page<UserListRecord> selectAllUsers(Pageable pageable);

    Optional<UserInfoRecord> selectUserBy(Long id);

    boolean existsUserBy(Long id);

    User getProxyUserBy(Long id);

    Long insertUser(User user);

    void updateUser(Long id, User user);

    void deleteUserBy(Long id);
}
