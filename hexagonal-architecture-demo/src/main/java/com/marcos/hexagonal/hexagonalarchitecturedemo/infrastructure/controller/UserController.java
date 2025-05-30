package com.marcos.hexagonal.hexagonalarchitecturedemo.infrastructure.controller;

import com.marcos.hexagonal.hexagonalarchitecturedemo.application.port.in.CreateUserUseCase;
import com.marcos.hexagonal.hexagonalarchitecturedemo.application.port.in.GetUserUseCase;
import com.marcos.hexagonal.hexagonalarchitecturedemo.domain.model.User;
import com.marcos.hexagonal.hexagonalarchitecturedemo.infrastructure.controller.dto.UserRequest;
import com.marcos.hexagonal.hexagonalarchitecturedemo.infrastructure.controller.dto.UserResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        User user = new User(null, userRequest.name(), userRequest.firstName());
        final User savedUser = createUserUseCase.createUser(user);
        return new UserResponse(savedUser.id(), savedUser.name(), savedUser.firstName());
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        User user = getUserUseCase.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User not found")
        );
        return new UserResponse(user.id(), user.name(), user.firstName());
    }
}
