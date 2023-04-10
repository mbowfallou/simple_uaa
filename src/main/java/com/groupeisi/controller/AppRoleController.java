package com.groupeisi.controller;

import com.groupeisi.entity.AppRoleEntity;
import com.groupeisi.service.AppRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class AppRoleController {
    private AppRoleService roleService;

    public AppRoleController(AppRoleService role) {
        this.roleService = role;
    }

    @GetMapping
    public List<AppRoleEntity> getRoles(){
        return roleService.getRoles();
    }

    @GetMapping("/{prenom}")
    public Optional<AppRoleEntity> getRoleByName(@PathVariable("prenom") String name){
        return roleService.getRoleByName(name);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppRoleEntity createRole(@Valid @RequestBody AppRoleEntity roleEntity){
        return roleService.createRole(roleEntity);
    }
}
