package com.axios.restapi.api.user;

import com.axios.restapi.business.user.UserService;
import com.axios.restapi.api.user.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUser(CreateUserRequest request) {
        Long newUserId = userService.registerUser(request.toData());
        return ResponseEntity.created(URI.create("/users/" + newUserId)).build();
    }
}
