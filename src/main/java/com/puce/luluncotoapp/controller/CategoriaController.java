package com.puce.luluncotoapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puce.luluncotoapp.dto.CategoriaResponse;
import com.puce.luluncotoapp.repository.CategoriaReporteRepository;

@RestController
@RequestMapping("/luluncoto/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaReporteRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> obtenerTodasLasCategorias() {
        List<CategoriaResponse> categorias = categoriaRepository.findAll()
                .stream()
                .map(c -> new CategoriaResponse(c.getId(), c.getNombre(), c.getDescripcion(), c.isEsPredefinida()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(categorias);
    }
}
