
package com.expresscafe.expresscafelogin.services;

import com.expresscafe.expresscafelogin.model.Usuarios;
import com.expresscafe.expresscafelogin.repository.UsuariosRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosServices {
    
    @Autowired
    private UsuariosRepository usuarioRepository;
            
    @Override
    public Usuarios newUsuarios(Usuarios newUsuarios) {
        return usuarioRepository.save(newUsuarios);
    }

    @Override
    public Iterable<Usuarios> getAll() {
       return this.usuarioRepository.findAll();
    }

    @Override
    public Usuarios modifyUsuarios(Usuarios usuarios) {
        
        Optional<Usuarios> usuariosEncontrado=  this.usuarioRepository.findById(usuarios.getId());
        if(usuariosEncontrado.get()!=null){
            usuariosEncontrado.get().setCedula(usuarios.getCedula());
            usuariosEncontrado.get().setNombre(usuarios.getNombre());
            usuariosEncontrado.get().setApellido(usuarios.getApellido());
            usuariosEncontrado.get().setEmpresacliente(usuarios.getEmpresacliente());
            usuariosEncontrado.get().setCorreo(usuarios.getCorreo());
            usuariosEncontrado.get().setCelular(usuarios.getCelular());
            usuariosEncontrado.get().setDireccion(usuarios.getDireccion());
            usuariosEncontrado.get().setCodigopostal(usuarios.getCodigopostal());
            usuariosEncontrado.get().setContraseña(usuarios.getContraseña());
            return this.newUsuarios(usuariosEncontrado.get());
        }
        return null;
    }

    @Override
    public Boolean deleteUsuarios(Long id) {
       this.usuarioRepository.deleteById(id);
       return true;
    }
    
    @Override
    public boolean validarCredenciales(String correo, String contraseña){
        Optional<Usuarios> usuarioOpt = usuarioRepository.findByCorreo(correo);
                return usuarioOpt.map(u-> u.getContraseña().equals(contraseña)).orElse(false);
    }
}
