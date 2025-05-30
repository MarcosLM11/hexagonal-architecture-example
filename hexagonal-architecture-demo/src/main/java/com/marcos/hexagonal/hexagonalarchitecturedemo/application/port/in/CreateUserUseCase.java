package com.marcos.hexagonal.hexagonalarchitecturedemo.application.port.in;

import com.marcos.hexagonal.hexagonalarchitecturedemo.domain.model.User;

public interface CreateUserUseCase {

    User createUser(User user);
}
