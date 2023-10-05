package com.is2.api.project.Models;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class Users implements UserDetails {
    @Id
    @GeneratedValue
    Integer id;
    @Basic
    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    String lastname;
    String firstname;
    String country;
    String password;
    @Enumerated(EnumType.STRING) 
    Role role;

    @OneToMany(mappedBy = "usuario")
    private Set<Contenido> contenidos = new HashSet<>();
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority((role.name())));
    }

    public void agregarContenido(Contenido contenido) {
        this.contenidos.add(contenido);
        contenido.setUsuario(this);
    }

    public void eliminarContenido(Contenido contenido) {
        this.contenidos.remove(contenido);
        contenido.setUsuario(null);
    }
    @Override
    public boolean isAccountNonExpired() {
       return true;
    }
    @Override
    public boolean isAccountNonLocked() {
       return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
