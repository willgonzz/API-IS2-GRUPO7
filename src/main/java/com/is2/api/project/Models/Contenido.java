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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idContenido;
    private String tituloContenido;
    private String codContenido;
    private Date fechaCreacion;
    private String descripcionContenido;
    private String informacionContenido;
    private Date fechaVigencia;
    private String tipoContenido;
    private String estado;


}
