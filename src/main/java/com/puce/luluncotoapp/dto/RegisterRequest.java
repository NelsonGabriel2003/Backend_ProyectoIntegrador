package com.puce.luluncotoapp.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
	@NotBlank(message = "El nombre es obligatorio")
	@Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
	private String nombre;
	
	@NotBlank(message = "El email es obligatorio")
	@Email(message = "El email no es válido")
	private String email;
	
	@NotBlank(message = "La contraseña es obligatoria")
	@Size(min = 10, message = "La contraseña debe tener mínimo 10 caracteres")
	private String contrasena;
	
	@NotBlank(message = "La cédula es obligatoria")
	@Size(min = 10, max = 10, message = "La cédula debe tener 10 caracteres")
	private String cedula;
	
	@NotBlank(message = "El celular es obligatorio")
	@Size(min = 10, max = 10, message = "El celular debe tener 10 dígitos")
	private String celular;
	
	@NotNull(message = "La fecha de nacimiento es obligatoria")
	@Past(message = "La fecha debe ser pasada")
	private LocalDate fechaDeNacimiento;

	public RegisterRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	

}
