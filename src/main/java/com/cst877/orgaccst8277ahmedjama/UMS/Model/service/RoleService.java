package com.cst877.orgaccst8277ahmedjama.UMS.Model.service;

import com.cst877.orgaccst8277ahmedjama.UMS.Model.Role;
import com.cst877.orgaccst8277ahmedjama.UMS.Model.repositor.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;


    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
