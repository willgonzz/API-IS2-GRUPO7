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
@Table(name = "reporte_categoria")
public class ReporteCategoria {
    @Id
    @GeneratedValue
    private String idReporteCategoria;
//    @OneToMany(mappedBy = "CategoriaContenido")
//    private List<CategoriaContenido> reporteCategoria;


}

