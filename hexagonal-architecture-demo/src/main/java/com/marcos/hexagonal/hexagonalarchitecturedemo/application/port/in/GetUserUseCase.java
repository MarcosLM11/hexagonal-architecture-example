package com.marcos.hexagonal.hexagonalarchitecturedemo.application.port.in;

import com.marcos.hexagonal.hexagonalarchitecturedemo.domain.model.User;

import java.util.Optional;

public interface GetUserUseCase {
    Optional<User> findById(Long id);
}
