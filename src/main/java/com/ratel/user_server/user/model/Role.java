package com.ratel.user_server.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String target;

    @ManyToMany(mappedBy = "roles")
    private List<Profile> profiles;

    /*@ManyToMany(mappedBy = "roles")
    private List<User> users;*/

}
