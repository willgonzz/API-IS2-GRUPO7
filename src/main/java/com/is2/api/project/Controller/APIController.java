package com.is2.api.project.Controller;

import com.is2.api.project.Auth.AuthResponse;
import com.is2.api.project.Auth.LoginRequest;
import com.is2.api.project.Jwt.JwtService;
import com.is2.api.project.Models.CategoriaContenido;
import com.is2.api.project.Models.Contenido;
import com.is2.api.project.Models.Role;
import com.is2.api.project.Models.Users;
import com.is2.api.project.Repository.ContenidoRepo;
import com.is2.api.project.Repository.UserRepository;
import com.is2.api.project.Services.RoleServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("auth/api")
@RequiredArgsConstructor
public class APIController {
    


    private final JwtService jwtService;

    private final UserRepository userRepository;

    private final ContenidoRepo contenidoRepo;

    @GetMapping("/mi-contenido")
    public List<Contenido> getContentUserById(Model model, @RequestBody AuthResponse authResponse){

        Users user=userRepository.findByUsername(jwtService.getUsernameFromToken(authResponse.getToken())).orElseThrow();
        List<Contenido> contenidos = contenidoRepo.findByUsuario(user);
        return contenidos;
    }

    @GetMapping("/todos-los-contenidos")
    public List<Contenido> getAllContent(Model model){
        List<Contenido> contenidos = contenidoRepo.findAll();
        return contenidos;
    }

    @GetMapping("/filtrar-contenido")
    public List<Contenido> getContentFilter(Model model,CategoriaContenido categoriaContenido){
        List<Contenido> contenidos = contenidoRepo.findByCategoriaContenido(categoriaContenido);
        return contenidos;
    }

    @PostMapping("/publicar-contenido")
    public ResponseEntity<Contenido> pushConten(@RequestBody AuthResponse authResponse){
        Users user=userRepository.findByUsername(jwtService.getUsernameFromToken(authResponse.getToken())).orElseThrow();
        Contenido contenido = new Contenido();
        contenido.setTituloContenido("Título del contenido");
        contenido.setDescripcionContenido("Descripción del contenido");
        contenido.setFechaCreacion(new Date());
        contenido.setUsuario(user);
        Contenido contenidoGuardado = contenidoRepo.save(contenido);
        return new ResponseEntity<>(contenido,HttpStatus.OK);
    }

    @GetMapping("/rolesDisponibles")
    public List<String> getRoles(Model model){
        List<String> enumValuesList = RoleServices.enumToList(Role.class);
        return enumValuesList;
    }

    @PostMapping("/modificar-rol-usuario")
    public ResponseEntity<Users> modificarRolUsuario(@RequestBody AuthResponse authResponse, @RequestBody Role role){
        Users user=userRepository.findByUsername(jwtService.getUsernameFromToken(authResponse.getToken())).orElseThrow();
        user.setRole(role);
        userRepository.save(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


}
