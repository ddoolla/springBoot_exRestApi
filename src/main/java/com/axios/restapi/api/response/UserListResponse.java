package com.axios.restapi.api.response;

import com.axios.restapi.persistence.record.UserListRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
@AllArgsConstructor
public class UserListResponse {

    private Page<UserListRecord> users;

}
