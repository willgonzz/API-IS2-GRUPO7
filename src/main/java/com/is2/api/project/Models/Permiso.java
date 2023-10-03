package com.is2.api.project.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permiso")
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPermiso;
    private String nombrePermiso;
    private String nivelPermiso;

    @ManyToMany(mappedBy = "permisos")
    private Set<Rol> roles = new HashSet<>();


}

