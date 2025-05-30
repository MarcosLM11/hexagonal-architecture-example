package com.marcos.hexagonal.hexagonalarchitecturedemo.infrastructure.persistance;

import com.marcos.hexagonal.hexagonalarchitecturedemo.application.port.out.UserRepositoryPort;
import com.marcos.hexagonal.hexagonalarchitecturedemo.domain.model.User;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final SpringDataUserRepository springDataUserRepository;

    public JpaUserRepositoryAdapter(SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity(user.id(), user.name(), user.firstName());
        final UserEntity savedUser = springDataUserRepository.save(userEntity);
        return new User(savedUser.getId(), savedUser.getName(), savedUser.getFirstName());
    }

    @Override
    public Optional<User> findById(Long id) {
        final UserEntity savedUser = springDataUserRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User not found")
        );
        return Optional.of(new User(savedUser.getId(), savedUser.getName(), savedUser.getFirstName()));
    }
}
