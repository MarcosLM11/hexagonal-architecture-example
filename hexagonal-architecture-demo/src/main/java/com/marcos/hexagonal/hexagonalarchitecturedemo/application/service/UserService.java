package com.marcos.hexagonal.hexagonalarchitecturedemo.application.service;

import com.marcos.hexagonal.hexagonalarchitecturedemo.application.port.in.CreateUserUseCase;
import com.marcos.hexagonal.hexagonalarchitecturedemo.application.port.in.GetUserUseCase;
import com.marcos.hexagonal.hexagonalarchitecturedemo.application.port.out.UserRepositoryPort;
import com.marcos.hexagonal.hexagonalarchitecturedemo.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements CreateUserUseCase, GetUserUseCase {

    private final UserRepositoryPort userRepository;

    public UserService(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
