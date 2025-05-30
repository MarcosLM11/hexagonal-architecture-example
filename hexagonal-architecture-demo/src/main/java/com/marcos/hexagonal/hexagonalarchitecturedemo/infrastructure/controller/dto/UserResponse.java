package com.marcos.hexagonal.hexagonalarchitecturedemo.infrastructure.controller.dto;

public record UserResponse(
        Long id,
        String name,
        String firstName
) {
}
