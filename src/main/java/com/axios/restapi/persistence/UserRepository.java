package com.axios.restapi.persistence;

import com.axios.restapi.persistence.record.UserListRecord;
import com.axios.restapi.persistence.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {

    Page<UserListRecord> selectAllUsers(Pageable pageable);

    Long insertUser(User user);


}
