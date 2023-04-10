package com.groupeisi.repository;

import com.groupeisi.entity.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAppUserRepository extends JpaRepository<AppUserEntity, Integer> {
    Optional<AppUserEntity> findByUsernameIgnoreCase(String username);
    Optional<AppUserEntity> findByEmailIgnoreCase(String username);
}
