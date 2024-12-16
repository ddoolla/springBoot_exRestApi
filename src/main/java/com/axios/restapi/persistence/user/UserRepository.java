package com.axios.restapi.persistence.user;

import com.axios.restapi.persistence.user.dto.UserListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {

    Page<UserListDto> selectAllUsers(Pageable pageable);

    Long insertUser(User user);


}
