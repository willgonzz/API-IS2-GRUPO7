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
@Table(name = "categoria_contenido")
public class CategoriaContenido {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombreCategoria;
    private String codCategoria;
    private String descripcionCategoria;

//
//    @OneToMany(mappedBy = "categoria")
//    private Set<Contenido> contenidos = new HashSet<>();
}
