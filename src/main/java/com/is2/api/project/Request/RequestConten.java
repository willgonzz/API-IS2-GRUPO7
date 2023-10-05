package com.is2.api.project.Request;

import com.is2.api.project.Auth.AuthResponse;
import com.is2.api.project.Models.Contenido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class RequestConten {
    AuthResponse authResponse;
    Contenido contenido;
}
