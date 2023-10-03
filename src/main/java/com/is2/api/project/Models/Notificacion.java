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
@Table(name = "notificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idNotificacion;
    private String contenidoNotificacion;


}

