package com.example.restapi.api.controller;

import com.example.restapi.api.response.ApiResponse;
import com.example.restapi.business.user.UserService;
import com.example.restapi.business.user.dto.UserInfoDto;
import com.example.restapi.business.user.dto.UserListDto;
import com.example.restapi.business.user.dto.request.UserCreateRequest;
import com.example.restapi.business.user.dto.request.UserUpdateRequest;
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
    public ResponseEntity<ApiResponse<UserListDto>> readManyUsers(@PageableDefault(size = 100) Pageable pageable) {
        return ResponseEntity.ok(new ApiResponse<>(userService.listUsers(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserInfoDto>> readOneUser(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(userService.getUserBy(id)));
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserCreateRequest request) {
        Long newUserId = userService.registerUser(request);
        return ResponseEntity.created(URI.create("/api/users/" + newUserId)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id,
                                           @Valid @RequestBody UserUpdateRequest request) {
        userService.editUser(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.removeUserBy(id);
        return ResponseEntity.noContent().build();
    }
}
