package com.is2.api.project.Request;

import com.is2.api.project.Models.Users;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class UsuariosReq {
    List<Users> users;
}
