package com.puce.luluncotoapp.dto;

public class EstadisticaEstadoResponse {
    private String estado;
    private Long cantidad;

    public EstadisticaEstadoResponse(String estado, Long cantidad) {
        this.estado = estado;
        this.cantidad = cantidad;
    }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Long getCantidad() { return cantidad; }
    public void setCantidad(Long cantidad) { this.cantidad = cantidad; }
}
