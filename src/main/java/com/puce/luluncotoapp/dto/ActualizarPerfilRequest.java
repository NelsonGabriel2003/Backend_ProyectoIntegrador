package com.puce.luluncotoapp.dto;

public class ActualizarPerfilRequest {
    private String nombre;
    private String celular;
    private String fotoPerfil;

    public ActualizarPerfilRequest() {}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
    public String getFotoPerfil() { return fotoPerfil; }
    public void setFotoPerfil(String fotoPerfil) { this.fotoPerfil = fotoPerfil; }
}
