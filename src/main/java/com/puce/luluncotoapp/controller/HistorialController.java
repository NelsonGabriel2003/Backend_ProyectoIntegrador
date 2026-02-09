package com.puce.luluncotoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puce.luluncotoapp.dto.HistorialResponse;
import com.puce.luluncotoapp.service.HistorialActividadService;

@RestController
@RequestMapping("/luluncoto/historial")
public class HistorialController {

    @Autowired
    private HistorialActividadService historialService;

    @GetMapping
    public ResponseEntity<List<HistorialResponse>> obtenerTodoElHistorial() {
        return ResponseEntity.ok(historialService.obtenerTodoElHistorial());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<HistorialResponse>> obtenerHistorialPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(historialService.obtenerHistorialPorUsuario(usuarioId));
    }

    @GetMapping("/entidad")
    public ResponseEntity<List<HistorialResponse>> obtenerHistorialPorEntidad(
            @RequestParam String entidad, @RequestParam Long entidadId) {
        return ResponseEntity.ok(historialService.obtenerHistorialPorEntidad(entidad, entidadId));
    }
}
