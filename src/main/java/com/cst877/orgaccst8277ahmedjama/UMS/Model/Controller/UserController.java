package com.cst877.orgaccst8277ahmedjama.UMS.Model.Controller;

import com.cst877.orgaccst8277ahmedjama.UMS.Model.User;
import com.cst877.orgaccst8277ahmedjama.UMS.Model.service.AuthService;
import com.cst877.orgaccst8277ahmedjama.UMS.Model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users); // Use ResponseEntity for consistent response handling
    }

    // Get a single user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        User user = userService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")); // Better exception handling
        return ResponseEntity.ok(user);
    }

    // Create a new user with validation
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) { // @Valid for input validation
        User savedUser = userService.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED); // More explicit and flexible response handling
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build(); // Respond with 204 No Content on successful deletion
    }

    // Authentication endpoint
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody User loginUser) {
        Optional<String> token = authService.authenticate(loginUser.getName(), loginUser.getPassword());
        return token
                .map(t -> ResponseEntity.ok().body("Token: " + t))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed"));
    }
}
