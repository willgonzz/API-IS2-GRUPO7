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
@Table(name = "comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idComentario;
    private String contenidoComentario;

}

