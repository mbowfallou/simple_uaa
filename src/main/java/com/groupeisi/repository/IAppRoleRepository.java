package com.groupeisi.repository;

import com.groupeisi.entity.AppRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAppRoleRepository extends JpaRepository<AppRoleEntity, Integer> {
    Optional<AppRoleEntity> findByNameIgnoreCase(String roleName);
}
