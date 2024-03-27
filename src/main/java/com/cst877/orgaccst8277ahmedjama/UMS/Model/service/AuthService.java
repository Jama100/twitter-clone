package com.cst877.orgaccst8277ahmedjama.UMS.Model.service;

import com.cst877.orgaccst8277ahmedjama.UMS.Model.User;
import com.cst877.orgaccst8277ahmedjama.UMS.Model.repositor.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public Optional<String> authenticate(String name, String password) {
        Optional<User> userResult = userRepository.findByName(name);

        if (userResult.isPresent() && userResult.get().getPassword().equals(password)) {

            String token = UUID.randomUUID().toString();

            return Optional.of(token);
        } else {
            return Optional.empty();
        }
    }

}
