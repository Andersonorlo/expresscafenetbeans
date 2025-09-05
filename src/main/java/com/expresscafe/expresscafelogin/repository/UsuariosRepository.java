//comunicacion entre el repositorio y la clase usuarios
package com.expresscafe.expresscafelogin.repository;

import com.expresscafe.expresscafelogin.model.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuariosRepository extends JpaRepository<Usuarios,Long> {

    
    Optional<Usuarios> findByCorreo(String correo);
    
}
