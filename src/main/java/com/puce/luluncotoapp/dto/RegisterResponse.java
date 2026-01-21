package com.puce.luluncotoapp.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class RegisterResponse {
    
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
    
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha debe ser pasada")
    private LocalDate fechadeNacimiento;
    
    public RegisterResponse() {
    }
    
    public RegisterResponse(String nombre, String email, String cedula, 
                           String celular, LocalDate fechadeNacimiento) {
        this.nombre = nombre;
        this.email = email;
        this.cedula = cedula;
        this.celular = celular;
        this.fechadeNacimiento = fechadeNacimiento;
    }
    
    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
    
    public LocalDate getFechadeNacimiento() { return fechadeNacimiento; }
    public void setFechadeNacimiento(LocalDate fechadeNacimiento) { 
        this.fechadeNacimiento = fechadeNacimiento; 
    }
}