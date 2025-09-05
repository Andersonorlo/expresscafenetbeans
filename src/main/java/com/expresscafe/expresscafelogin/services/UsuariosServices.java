//define metodos 
package com.expresscafe.expresscafelogin.services;

import com.expresscafe.expresscafelogin.model.Usuarios;


public interface UsuariosServices {
    Usuarios newUsuarios (Usuarios newUsuarios);
    Iterable<Usuarios> getAll();
    Usuarios modifyUsuarios(Usuarios newUsuarios);
    Boolean deleteUsuarios (Long id);

    public boolean validarCredenciales(String correo, String contraseña);
}
