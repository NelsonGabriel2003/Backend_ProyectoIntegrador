package com.puce.luluncotoapp.dto;

import java.util.List;

public class ResumenEstadisticasResponse {
    private Long totalReportes;
    private List<EstadisticaCategoriaResponse> reportesPorCategoria;
    private List<EstadisticaEstadoResponse> reportesPorEstado;

    public ResumenEstadisticasResponse() {}

    public ResumenEstadisticasResponse(Long totalReportes,
                                       List<EstadisticaCategoriaResponse> reportesPorCategoria,
                                       List<EstadisticaEstadoResponse> reportesPorEstado) {
        this.totalReportes = totalReportes;
        this.reportesPorCategoria = reportesPorCategoria;
        this.reportesPorEstado = reportesPorEstado;
    }

    public Long getTotalReportes() { return totalReportes; }
    public void setTotalReportes(Long totalReportes) { this.totalReportes = totalReportes; }
    public List<EstadisticaCategoriaResponse> getReportesPorCategoria() { return reportesPorCategoria; }
    public void setReportesPorCategoria(List<EstadisticaCategoriaResponse> reportesPorCategoria) { this.reportesPorCategoria = reportesPorCategoria; }
    public List<EstadisticaEstadoResponse> getReportesPorEstado() { return reportesPorEstado; }
    public void setReportesPorEstado(List<EstadisticaEstadoResponse> reportesPorEstado) { this.reportesPorEstado = reportesPorEstado; }
}
