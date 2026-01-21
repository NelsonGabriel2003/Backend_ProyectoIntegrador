package com.puce.luluncotoapp.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class UserResponse {
    
    @NotNull(message = "El id es obligatorio")
    private Long id;
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre es muy largo")
    private String nombre;
    
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no es válido")
    private String email;
    
    @NotBlank(message = "La cédula es obligatoria")
    @Size(min = 10, max = 10, message = "La cédula debe tener 10 caracteres")
    private String cedula;
    
    @NotBlank(message = "El celular es obligatorio")
    @Size(min = 10, max = 10, message = "El celular solo tiene 10 dígitos")
    private String celular;
    
    private String fotoPerfil;
    
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha debe ser pasada")
    private LocalDate fechaDeNacimiento;
    
    public UserResponse() {
    }
    
    public UserResponse(Long id, String nombre, String email, String cedula, 
                       String celular, String fotoPerfil, LocalDate fechaDeNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.cedula = cedula;
        this.celular = celular;
        this.fotoPerfil = fotoPerfil;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
    
    public String getFotoPerfil() { return fotoPerfil; }
    public void setFotoPerfil(String fotoPerfil) { this.fotoPerfil = fotoPerfil; }
    
    public LocalDate getFechaDeNacimiento() { return fechaDeNacimiento; }
    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) { 
        this.fechaDeNacimiento = fechaDeNacimiento; 
    }
}