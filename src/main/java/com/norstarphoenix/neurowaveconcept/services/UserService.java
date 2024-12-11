package com.norstarphoenix.neurowaveconcept.services;

import ch.qos.logback.core.model.Model;
import com.norstarphoenix.neurowaveconcept.models.User;
import com.norstarphoenix.neurowaveconcept.repositories.UserRepository;
import com.norstarphoenix.neurowaveconcept.utils.AuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthHelper authHelper;

    @Autowired
    public UserService(UserRepository userRepository, AuthHelper authHelper) {
        this.userRepository = userRepository;
        this.authHelper = authHelper;
    }

    public boolean loginUser(User user, Model model) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());

        if (optionalUser.isPresent()) {
            User storedUser = optionalUser.get();

            if (authHelper.validatePassword(storedUser.getPasswordHash(), user.getPassword())) {
                return true;
            }
        }

        model.addAttribute("error", "Invalid username or password");
        return false;
    }

    public void registerUser(User user) {
        user.setPasswordHash(authHelper.getPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }
}
