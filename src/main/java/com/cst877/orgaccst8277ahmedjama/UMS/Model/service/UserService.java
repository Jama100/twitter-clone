package com.cst877.orgaccst8277ahmedjama.UMS.Model.service;

import com.cst877.orgaccst8277ahmedjama.UMS.Model.User;
import com.cst877.orgaccst8277ahmedjama.UMS.Model.repositor.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findByUsername(String name) {
        return userRepository.findByName(name);
    }
}
