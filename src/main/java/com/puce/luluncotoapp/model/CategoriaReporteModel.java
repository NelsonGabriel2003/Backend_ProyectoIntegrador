package com.puce.luluncotoapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias_reporte")
public class CategoriaReporteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String nombre;

    @Column(length = 200)
    private String descripcion;

    @Column(nullable = false)
    private boolean esPredefinida;

    public CategoriaReporteModel() {
    }

    public CategoriaReporteModel(Long id, String nombre, String descripcion, boolean esPredefinida) {
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
