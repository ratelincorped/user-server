package com.ratel.user_server.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Profile {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
//    private Long pin;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "ProfileRole",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    public List<String> getRoleNames() {
        return getRoles()
                .stream()
                .filter(role -> role.getTarget()
                        .equalsIgnoreCase("user service")
                ).map(Role::getName)
                .toList();
    }

}
