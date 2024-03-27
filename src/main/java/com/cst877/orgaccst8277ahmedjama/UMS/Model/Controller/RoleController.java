package com.cst877.orgaccst8277ahmedjama.UMS.Model.Controller;

import com.cst877.orgaccst8277ahmedjama.UMS.Model.Role;
import com.cst877.orgaccst8277ahmedjama.UMS.Model.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }
}
