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
@Table(name = "historial_contenido")
public class HistorialContenido {
    @Id
    @GeneratedValue
    private Integer id;
    private String versionesContenido;
}

