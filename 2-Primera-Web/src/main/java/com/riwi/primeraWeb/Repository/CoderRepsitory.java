package com.riwi.primeraWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.riwi.primeraWeb.Entity.Coder;

// @Repository se encarga de toda la persistencia de los datos, interactua directamente con la base de datos
@Repository
// Extendemos de la interfaz de JPA para obtener todos los métodos del CRUD
public interface CoderRepsitory extends JpaRepository<Coder, Long>{

}
