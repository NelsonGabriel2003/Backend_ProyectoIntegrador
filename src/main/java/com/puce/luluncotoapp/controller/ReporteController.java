package com.puce.luluncotoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puce.luluncotoapp.dto.ActualizarEstadoRequest;
import com.puce.luluncotoapp.dto.CrearReporteRequest;
import com.puce.luluncotoapp.dto.ReporteResponse;
import com.puce.luluncotoapp.service.ReporteService;

@RestController
@RequestMapping("/luluncoto/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @PostMapping
    public ResponseEntity<ReporteResponse> crearReporte(@RequestBody CrearReporteRequest request) {
        ReporteResponse reporte = reporteService.crearReporte(request);
        return new ResponseEntity<>(reporte, HttpStatus.CREATED);
    }

    @GetMapping("/mis-reportes")
    public ResponseEntity<List<ReporteResponse>> obtenerMisReportes() {
        return ResponseEntity.ok(reporteService.obtenerMisReportes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteResponse> obtenerReportePorId(@PathVariable Long id) {
        return ResponseEntity.ok(reporteService.obtenerReportePorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ReporteResponse>> obtenerTodosLosReportes() {
        return ResponseEntity.ok(reporteService.obtenerTodosLosReportes());
    }

    @GetMapping("/por-estado")
    public ResponseEntity<List<ReporteResponse>> obtenerPorEstado(@RequestParam String estado) {
        return ResponseEntity.ok(reporteService.obtenerReportesPorEstado(estado));
    }

    @GetMapping("/por-categoria/{categoriaId}")
    public ResponseEntity<List<ReporteResponse>> obtenerPorCategoria(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(reporteService.obtenerReportesPorCategoria(categoriaId));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<ReporteResponse> actualizarEstado(@PathVariable Long id, @RequestBody ActualizarEstadoRequest request) {
        return ResponseEntity.ok(reporteService.actualizarEstado(id, request.getEstado()));
    }
}
