package com.puce.luluncotoapp.dto;

import java.time.LocalDateTime;

public class HistorialResponse {
    private Long id;
    private String usuarioNombre;
    private Long usuarioId;
    private String accion;
    private String entidad;
    private Long entidadId;
    private String detalle;
    private LocalDateTime fechaHora;

    public HistorialResponse() {}

    public HistorialResponse(Long id, String usuarioNombre, Long usuarioId, String accion,
                             String entidad, Long entidadId, String detalle, LocalDateTime fechaHora) {
        this.id = id;
        this.usuarioNombre = usuarioNombre;
        this.usuarioId = usuarioId;
        this.accion = accion;
        this.entidad = entidad;
        this.entidadId = entidadId;
        this.detalle = detalle;
        this.fechaHora = fechaHora;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsuarioNombre() { return usuarioNombre; }
    public void setUsuarioNombre(String usuarioNombre) { this.usuarioNombre = usuarioNombre; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }
    public String getEntidad() { return entidad; }
    public void setEntidad(String entidad) { this.entidad = entidad; }
    public Long getEntidadId() { return entidadId; }
    public void setEntidadId(Long entidadId) { this.entidadId = entidadId; }
    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
}
