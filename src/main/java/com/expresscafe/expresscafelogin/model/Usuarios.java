// clase para la entidad de la aplicacion
package com.expresscafe.expresscafelogin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 

@Entity
@Data
@Table(name = "usuarios")

public class Usuarios {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cedula;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String empresacliente;
    @Column
    private String correo;
    @Column
    private String celular;
    @Column
    private String direccion;
    @Column
    private String codigopostal;
    @Column
    private String contraseña;
}