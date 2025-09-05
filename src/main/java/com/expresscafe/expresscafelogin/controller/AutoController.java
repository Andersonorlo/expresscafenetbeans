
package com.expresscafe.expresscafelogin.controller;


import com.expresscafe.expresscafelogin.dto.LoginRequest;
import com.expresscafe.expresscafelogin.model.Usuarios;
import com.expresscafe.expresscafelogin.services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auto")

public class AutoController {
    
    @Autowired
    private UsuariosServices usuariosServices;
    
    @PostMapping("/registro")
    public ResponseEntity<Usuarios>registrar(@RequestBody Usuarios nuevoUsuario) {
        Usuarios registrado = usuariosServices.newUsuarios(nuevoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(registrado);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean valido = usuariosServices.validarCredenciales(loginRequest.getCorreo(), loginRequest.getContraseña());
        if (valido) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}

