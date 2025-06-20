package com.marcos.hexagonal.hexagonalarchitecturedemo.infrastructure.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String firstName;
}
