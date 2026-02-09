package com.puce.luluncotoapp.dto;

import java.time.LocalDateTime;

public class ReporteResponse {
    private Long id;
    private String titulo;
    private String descripcion;
    private String fotoUrl;
    private Double latitud;
    private Double longitud;
    private String estado;
    private String categoriaNombre;
    private Long categoriaId;
    private String usuarioNombre;
    private Long usuarioId;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;

    public ReporteResponse() {}

    public ReporteResponse(Long id, String titulo, String descripcion, String fotoUrl,
                           Double latitud, Double longitud, String estado,
                           String categoriaNombre, Long categoriaId,
                           String usuarioNombre, Long usuarioId,
                           LocalDateTime creadoEn, LocalDateTime actualizadoEn) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fotoUrl = fotoUrl;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estado = estado;
        this.categoriaNombre = categoriaNombre;
        this.categoriaId = categoriaId;
        this.usuarioNombre = usuarioNombre;
        this.usuarioId = usuarioId;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }
    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getCategoriaNombre() { return categoriaNombre; }
    public void setCategoriaNombre(String categoriaNombre) { this.categoriaNombre = categoriaNombre; }
    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
    public String getUsuarioNombre() { return usuarioNombre; }
    public void setUsuarioNombre(String usuarioNombre) { this.usuarioNombre = usuarioNombre; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public LocalDateTime getCreadoEn() { return creadoEn; }
    public void setCreadoEn(LocalDateTime creadoEn) { this.creadoEn = creadoEn; }
    public LocalDateTime getActualizadoEn() { return actualizadoEn; }
    public void setActualizadoEn(LocalDateTime actualizadoEn) { this.actualizadoEn = actualizadoEn; }
}
