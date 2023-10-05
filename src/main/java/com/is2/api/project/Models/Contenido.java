package com.is2.api.project.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contenido")
public class Contenido {
    @Id
    @GeneratedValue
    private Integer id;
    private String tituloContenido;
    private String codContenido;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    private String descripcionContenido;
    private String informacionContenido;
    private Date fechaVigencia;
    private String tipoContenido;
    private String estado;


    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Users usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaContenido categoriaContenido;


}
