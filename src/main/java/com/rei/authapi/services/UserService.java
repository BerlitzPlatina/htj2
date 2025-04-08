package com.rei.authapi.services;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.rei.authapi.dtos.RegisterUserDto;
import com.rei.authapi.entities.Role;
import com.rei.authapi.entities.RoleEnum;
import com.rei.authapi.entities.User;
import com.rei.authapi.repositories.RoleRepository;
import com.rei.authapi.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Family not found"));
    }

    public User createAdministrator(RegisterUserDto input) {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.ADMIN);

        if (optionalRole.isEmpty()) {
            return null;
        }

        var user = new User().setFullName(input.getFullName()).setEmail(input.getEmail())
                .setPassword(passwordEncoder.encode(input.getPassword()))
                .setRole(optionalRole.get());

        return userRepository.save(user);
    }
}
