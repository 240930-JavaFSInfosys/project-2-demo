package com.revature.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Component //This Class will be registered as a Spring Bean
@Entity //This Class will be created as a table in the DB (In other words, a DB ENTITY)
@Table(name = "users") //@Table lets us set properties like table name. THIS IS NOT WHAT MAKES IT A TABLE
public class User implements UserDetails {

    //HI Spring Security^^^ This Class implements UserDetails for use in Spring Security Authentication
    //Now we can use this Class in our utils (WebSecurityConfig and JwtTokenFilter)

    @Id //This makes the field the primary key
    @GeneratedValue(strategy = GenerationType.UUID) //This makes our PK auto-increment (like serial)
    private UUID userId;

    /* @Column isn't necessary UNLESS you want to set a name, or set constraints
       -nullable = NOT NULL constraint
       -unique = UNIQUE constraint */

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role = "user"; //setting default role to 'user'


    /*One to Many relationship (goes hand in hand with the @ManyToOne in Pet)

     mappedBy: This refers to the @ManyToOne field in Pet that maps this relationship (user)

     fetch: refer to the Pet class for info on this guy

     cascade: This lets us define what operations cascade down to dependent records\
        -CascadeType.ALL = all operations cascade down to dependent records (update, delete, etc) */
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore //prevents the circular reference in our JSON responses
    private List<Pet> pets;

    //boilerplate----------------------------------no args, all args, getter/setter/ toString

    public User() {}

    public User(UUID userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    //Boilerplate overrides from UserDetails--------------------------

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    //Boilerplate overrides from UserDetails----------------------------

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
