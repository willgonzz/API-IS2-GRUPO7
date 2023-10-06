package com.is2.api.project.Controller;

import com.is2.api.project.Auth.AuthResponse;
import com.is2.api.project.Jwt.JwtService;
import com.is2.api.project.Models.*;
import com.is2.api.project.Repository.CategoriaRepo;
import com.is2.api.project.Repository.ContenidoRepo;
import com.is2.api.project.Repository.UserRepository;
import com.is2.api.project.Request.RequestConten;
import com.is2.api.project.Request.StatusContentReq;
import com.is2.api.project.Request.UsuariosReq;
import com.is2.api.project.Services.EmailService;
import com.is2.api.project.Request.CambioRolReq;
import com.is2.api.project.Services.EnumServices;
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

    private final CategoriaRepo categoriaRepo;


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


    @GetMapping("/obtener-categorias")
    public List<CategoriaContenido> getCategorias(){
        List<CategoriaContenido> listCate = categoriaRepo.findAll();
        return listCate;
    }

    @PostMapping("/publicar-contenido")
    public ResponseEntity<Contenido> pushConten(@RequestBody RequestConten req){
        Users user=userRepository.findByUsername(jwtService.getUsernameFromToken(req.getAuthResponse().getToken())).orElseThrow();
        req.getContenido().setFechaCreacion(new Date());
        req.getContenido().setUsuario(user);
        req.getContenido().setState(StateContenido.BORRADOR);
        Contenido contenidoGuardado = contenidoRepo.save(req.getContenido());

        EmailService.sendEmail(user.getMail(),"PUBLICACION DE CONTENIDO", "ARTICULO PUBLICADO PARA REVISION");
        return new ResponseEntity<>(contenidoGuardado,HttpStatus.OK);
    }

    @PostMapping("/modificar-estado-contenido")
    public ResponseEntity<Contenido> saveStatusContenido(@RequestBody StatusContentReq statusContentReq){
        Contenido contenido = contenidoRepo.findById(statusContentReq.getId()).orElseThrow();
        contenido.setState(statusContentReq.getStatus());
        Contenido contenidoGuardado = contenidoRepo.save(contenido);
        return new ResponseEntity<>(contenidoGuardado, HttpStatus.OK);
    }


    @GetMapping("/estados-disponibles")
    public List<String> getstateContenidos(){
        List<String> enumValuesList = EnumServices.enumToList(StateContenido.class);
        return enumValuesList;
    }

    @GetMapping("/roles-disponibles")
    public List<String> getRoles(Model model){
        List<String> enumValuesList = EnumServices.enumToList(Role.class);
        return enumValuesList;
    }

    @PostMapping("/modificar-rol-usuario")
    public ResponseEntity<Users> modificarRolUsuario(@RequestBody CambioRolReq cambioRolReq){
        Users user=userRepository.findByUsername(cambioRolReq.getUsername()).orElseThrow();
        user.setRole(cambioRolReq.getRole());
        userRepository.save(user);
        EmailService.sendEmail(user.getMail(),"CAMBIO DE ROL", "Se le asigno el Rol: "+user.getRole().name());

        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping("/obtener-usuarios")
    public UsuariosReq getUsers(){
        List<Users> users = userRepository.findAll();
        UsuariosReq usuariosReq = new UsuariosReq();
        usuariosReq.setUsers(users);
        return usuariosReq;
    }

}
