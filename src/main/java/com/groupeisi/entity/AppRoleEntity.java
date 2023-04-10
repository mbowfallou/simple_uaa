package com.groupeisi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity @Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;
    //@ManyToMany(mappedBy = "roles") private Set<AppUserEntity> users = new HashSet<>();
}
