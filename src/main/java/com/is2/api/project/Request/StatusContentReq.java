package com.is2.api.project.Request;


import com.is2.api.project.Models.StateContenido;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class StatusContentReq {
    Long id;
    StateContenido status;
}
