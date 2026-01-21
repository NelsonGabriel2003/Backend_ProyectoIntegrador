package com.puce.luluncotoapp.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Users")
public class UserModel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=50, nullable=false)
	@Size(max=50, message= "El nombre no puede superar los 50 caracteres")
	@NotBlank(message= "El nombre es obligatorio")
	private String nombre;
	
	@Column(length=60, nullable=false, unique=true)
	@Size(max=60)
	@Email(message= "El email no es valido")
	@NotBlank(message= "El email es obligatorio")
	private String email;
	
	@Column(length=200, nullable=false)
	@Size(min=10, message="La contraseña segura debe tener 10 caracteres")
	@NotBlank(message= "La contraseña es obligatoria")
	private String contrasena;
	
	@Column(length=10, unique=true , nullable=false)
	@Size(min=10, max=10, message="La cedula solo debe contener 10 caracteres")
	@NotBlank(message= "La cedula es obligatorio")
	private String cedula;
	
	@Column(length=10, unique=false, nullable=true)
	@Size(min=10, max=10, message="El celular debe tener 10 digitos")
	@NotBlank(message= "El celular es obligatorio")
	private String celular;
	
	@Column(nullable=false)
	@NotNull(message= "Debemos saber tu edad")
	@Past(message = "La fecha de nacimiento debe ser una fecha pasada")
	private LocalDate fechadeNacimiento;
	
	@Column(length=500,nullable=true)
	private String fotoPerfil;
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserModel(Long id,
			@Size(max = 50, message = "El nombre no puede superar los 50 caracteres") @NotBlank(message = "El nombre es obligatorio") String nombre,
			@Size(max = 60) @Email(message = "El email no es valido") @NotBlank(message = "El email es obligatorio") String email,
			@Size(min = 10, message = "La contraseña segura debe tener 10 caracteres") @NotBlank(message = "La contraseña es obligatoria") String contrasena,
			@Size(min = 10, max = 10, message = "La cedula solo debe contener 10 caracteres") @NotBlank(message = "La cedula es obligatorio") String cedula,
			@Size(min = 10, max = 10, message = "El celular debe tener 10 digitos") @NotBlank(message = "El celular es obligatorio") String celular,
			@NotNull(message = "Debemos comprobar tu edad con la fecha de nacimiento") @Past(message = "La fecha de nacimiento debe ser una fecha pasada") LocalDate fechadeNacimiento,
			String fotoPerfil) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.contrasena = contrasena;
		this.cedula = cedula;
		this.celular = celular;
		this.fechadeNacimiento = fechadeNacimiento;
		this.fotoPerfil = fotoPerfil;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String name) {
		this.nombre = name;
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
	public LocalDate getFechadeNacimiento() {
		return fechadeNacimiento;
	}
	public void setFechadeNacimiento(LocalDate fechadeNacimiento) {
		this.fechadeNacimiento = fechadeNacimiento;
	}
	public String getFotoPerfil() {
		return fotoPerfil;
	}
	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	
	
	
}
