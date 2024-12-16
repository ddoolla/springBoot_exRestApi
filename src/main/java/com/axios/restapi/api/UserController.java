package com.axios.restapi.api;

import com.axios.restapi.api.response.UserListResponse;
import com.axios.restapi.business.UserService;
import com.axios.restapi.api.request.UserCreateRequest;
import com.axios.restapi.business.dto.UserListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserListResponse> readManyUsers(@PageableDefault(size = 20) Pageable pageable) {
        Page<UserListDto> userPages = userService.listUsers(pageable);
        return ResponseEntity.ok(new UserListResponse(userPages));
    }

    @PostMapping
    public ResponseEntity<Void> createUser(UserCreateRequest request) {
        Long newUserId = userService.registerUser(request.toData());
        return ResponseEntity.created(URI.create("/users/" + newUserId)).build();
    }
}
