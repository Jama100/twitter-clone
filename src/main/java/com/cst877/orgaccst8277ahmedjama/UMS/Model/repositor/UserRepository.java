package com.cst877.orgaccst8277ahmedjama.UMS.Model.repositor;

import com.cst877.orgaccst8277ahmedjama.UMS.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByName(String name);
}