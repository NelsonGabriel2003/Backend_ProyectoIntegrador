package com.puce.luluncotoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puce.luluncotoapp.dto.ResumenEstadisticasResponse;
import com.puce.luluncotoapp.service.EstadisticaService;

@RestController
@RequestMapping("/luluncoto/estadisticas")
public class EstadisticaController {

    @Autowired
    private EstadisticaService estadisticaService;

    @GetMapping
    public ResponseEntity<ResumenEstadisticasResponse> obtenerResumen() {
        return ResponseEntity.ok(estadisticaService.obtenerResumen());
    }
}
