// llamada los metodos para la comunicacion a la web

package com.expresscafe.expresscafelogin.controller;

import com.expresscafe.expresscafelogin.model.Usuarios;
import com.expresscafe.expresscafelogin.services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    
    @Autowired
    private UsuariosServices usuariosServices;
    
    @PostMapping("/nuevo")
    public Usuarios newusuarios(@RequestBody Usuarios newusuarios){
        return this.usuariosServices.newUsuarios(newusuarios);
    }
    
    @GetMapping("/mostrar")
    public Iterable<Usuarios> getAll(){
        return usuariosServices.getAll();
    }
    
    @PostMapping("/modificar")
    public Usuarios updateUsuarios(@RequestBody Usuarios usuarios){
        return this.usuariosServices.modifyUsuarios(usuarios);
    }
    
    @PostMapping(value="/{id}")
    public Boolean deleteUsuarios(@PathVariable(value="id") Long id){
        return this.usuariosServices.deleteUsuarios(id);
    }
    
}