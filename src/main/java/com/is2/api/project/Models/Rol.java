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
@Table(name ="rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idRol;
    private String nombreRol;
    private String descripcionRol;
    private Integer idRermiso;

    @ManyToMany
    @JoinTable(
            name = "rol_permiso",
            joinColumns = @JoinColumn(name = "id_rol"),
            inverseJoinColumns = @JoinColumn(name = "id_permiso")
    )
    private Set<Permiso> permisos = new HashSet<>();


}
