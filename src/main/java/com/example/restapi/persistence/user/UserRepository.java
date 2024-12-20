package com.example.restapi.persistence.user;

import com.example.restapi.persistence.user.record.UserInfoRecord;
import com.example.restapi.persistence.user.record.UserRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserRepository {

    Page<UserRecord> selectAllUsers(Pageable pageable);

    Optional<UserInfoRecord> selectUserBy(Long id);

    boolean existsUserBy(Long id);

    User getProxyUserBy(Long id);

    Long insertUser(User user);

    void updateUser(Long id, User user);

    void deleteUserBy(Long id);
}
