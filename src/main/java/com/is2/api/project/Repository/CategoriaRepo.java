package com.is2.api.project.Repository;


import com.is2.api.project.Models.CategoriaContenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CategoriaRepo extends JpaRepository<CategoriaContenido,Long> {

}
