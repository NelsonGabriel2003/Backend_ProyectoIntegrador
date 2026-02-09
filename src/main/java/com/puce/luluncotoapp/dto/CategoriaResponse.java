package com.puce.luluncotoapp.dto;

public class CategoriaResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private boolean esPredefinida;

    public CategoriaResponse() {}

    public CategoriaResponse(Long id, String nombre, String descripcion, boolean esPredefinida) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.esPredefinida = esPredefinida;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public boolean isEsPredefinida() { return esPredefinida; }
    public void setEsPredefinida(boolean esPredefinida) { this.esPredefinida = esPredefinida; }
}
