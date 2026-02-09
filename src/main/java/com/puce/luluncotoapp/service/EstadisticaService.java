package com.puce.luluncotoapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.puce.luluncotoapp.dto.EstadisticaCategoriaResponse;
import com.puce.luluncotoapp.dto.EstadisticaEstadoResponse;
import com.puce.luluncotoapp.dto.ResumenEstadisticasResponse;
import com.puce.luluncotoapp.exception.AccesoDenegadoException;
import com.puce.luluncotoapp.exception.UsuarioNoEncontradoException;
import com.puce.luluncotoapp.model.UserModel;
import com.puce.luluncotoapp.repository.ReporteRepository;
import com.puce.luluncotoapp.repository.UserRepository;

@Service
public class EstadisticaService {

    @Autowired
    private ReporteRepository reporteRepository;

    @Autowired
    private UserRepository userRepository;

    private void verificarAdmin() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        UserModel usuario = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsuarioNoEncontradoException("Usuario no encontrado"));
        if (!"ADMIN".equals(usuario.getRol().getNombre())) {
            throw new AccesoDenegadoException("Solo los administradores pueden ver las estadísticas");
        }
    }

    public ResumenEstadisticasResponse obtenerResumen() {
        verificarAdmin();

        Long totalReportes = reporteRepository.count();

        List<EstadisticaCategoriaResponse> porCategoria = reporteRepository.contarReportesPorCategoria()
                .stream()
                .map(fila -> new EstadisticaCategoriaResponse((String) fila[0], (Long) fila[1]))
                .collect(Collectors.toList());

        List<EstadisticaEstadoResponse> porEstado = reporteRepository.contarReportesPorEstado()
                .stream()
                .map(fila -> new EstadisticaEstadoResponse((String) fila[0], (Long) fila[1]))
                .collect(Collectors.toList());

        return new ResumenEstadisticasResponse(totalReportes, porCategoria, porEstado);
    }
}
