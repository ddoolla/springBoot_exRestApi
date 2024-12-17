package com.axios.restapi.api;

import com.axios.restapi.api.response.UserInfoResponse;
import com.axios.restapi.api.response.UserListResponse;
import com.axios.restapi.business.UserService;
import com.axios.restapi.api.request.UserCreateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserListResponse> readManyUsers(@PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(new UserListResponse(userService.listUsers(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfoResponse> readOneUser(@PathVariable Long id) {
        return ResponseEntity.ok(new UserInfoResponse(userService.getUserBy(id)));
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserCreateRequest request) {
        Long newUserId = userService.registerUser(request.toDto());
        return ResponseEntity.created(URI.create("/api/users/" + newUserId)).build();
    }
}
