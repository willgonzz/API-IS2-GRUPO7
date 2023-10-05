package com.is2.api.project.Request;

import com.is2.api.project.Models.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CambioRolReq {
    String username;
    Role role;
}
