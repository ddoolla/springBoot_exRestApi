package com.axios.restapi.business;

import com.axios.restapi.business.dto.UserCreateDto;
import com.axios.restapi.persistence.record.UserListRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserListRecord> listUsers(Pageable pageable);

    Long registerUser(UserCreateDto data);
}
