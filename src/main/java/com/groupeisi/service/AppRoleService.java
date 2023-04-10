package com.groupeisi.service;

import com.groupeisi.entity.AppRoleEntity;
import com.groupeisi.repository.IAppRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppRoleService {
    private IAppRoleRepository roleRepository;

    public AppRoleService(IAppRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public AppRoleEntity createRole(AppRoleEntity roleEntity) {
        if (roleEntity.getName() == null || roleEntity.getName().isEmpty()) {
            throw new IllegalArgumentException("Le nom du rôle ne peut pas être nul ou vide");
        }
        if (roleRepository.findByNameIgnoreCase(roleEntity.getName()).isPresent())
            throw new IllegalStateException("Un rôle avec ce nom existe déjà");

        return roleRepository.save(roleEntity);
    }
    public Optional<AppRoleEntity> getRoleByName(String name) {
        return roleRepository.findByNameIgnoreCase(name);
    }

    public List<AppRoleEntity> getRoles(){
        return roleRepository.findAll();
    }
}
