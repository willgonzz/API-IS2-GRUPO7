package com.is2.api.project.Repository;


import com.is2.api.project.Models.CategoriaContenido;
import com.is2.api.project.Models.Contenido;
import com.is2.api.project.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ContenidoRepo extends JpaRepository<Contenido,Long> {

    List<Contenido> findByUsuario(Users usuario);

    List<Contenido> findByCategoriaContenido(CategoriaContenido categoriaContenido);
}
