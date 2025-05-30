package com.marcos.hexagonal.hexagonalarchitecturedemo.application.port.out;

import com.marcos.hexagonal.hexagonalarchitecturedemo.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(Long id);
}
