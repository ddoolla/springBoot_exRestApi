package com.axios.restapi.api;

import com.axios.restapi.api.response.UserListResponse;
import com.axios.restapi.business.UserService;
import com.axios.restapi.api.request.UserCreateRequest;
import com.axios.restapi.business.dto.UserListDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
        Page<UserListDto> userPages = userService.listUsers(pageable);
        return ResponseEntity.ok(new UserListResponse(userPages));
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserCreateRequest request) {
        Long newUserId = userService.registerUser(request.toDto());
        return ResponseEntity.created(URI.create("/api/users/" + newUserId)).build();
    }
}
