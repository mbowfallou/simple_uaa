package com.groupeisi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity @Table(name = "users_table") @Inheritance(strategy = InheritanceType.JOINED)
@Data @AllArgsConstructor @NoArgsConstructor
public class AppUserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    @Column(length = 150)
    private String address;
    private String phone;
    @Column(length = 200, unique = true, nullable = false)
    private String email;
    @Column(length = 120, unique = true, nullable = false)
    private String username;
    private String password;

//    @Override
//    public int hashCode() {
//        return Objects.hash(username, email);
//    }
    @ManyToMany(fetch = FetchType.EAGER) // , cascade = CascadeType.ALL
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<AppRoleEntity> roles = new HashSet<>();

    public void addRole(AppRoleEntity role) {
        roles.add(role);
    }

    public void removeRole(AppRoleEntity role) {
        roles.remove(role);
    }

    public void removeAllRoles() {
        roles.clear();
    }
}
