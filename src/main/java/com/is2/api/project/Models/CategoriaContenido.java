package com.is2.api.project.Models;

import jakarta.persistence.*;
import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCategoria;
    private String nombreCategoria;
    private String codCategoria;
    private String descripcionCategoria;

}
