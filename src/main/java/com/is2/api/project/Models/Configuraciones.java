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
@Table(name = "configuracion")
public class Configuraciones {
    @Id
    @GeneratedValue
    private Integer id;
    private String configuraciones;


}

