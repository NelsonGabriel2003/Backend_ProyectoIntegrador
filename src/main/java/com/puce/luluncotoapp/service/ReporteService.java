package com.puce.luluncotoapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.puce.luluncotoapp.dto.CrearReporteRequest;
import com.puce.luluncotoapp.dto.ReporteResponse;
import com.puce.luluncotoapp.exception.AccesoDenegadoException;
import com.puce.luluncotoapp.exception.RecursoNoEncontradoException;
import com.puce.luluncotoapp.exception.UsuarioNoEncontradoException;
import com.puce.luluncotoapp.model.CategoriaReporteModel;
import com.puce.luluncotoapp.model.ReporteModel;
import com.puce.luluncotoapp.model.UserModel;
import com.puce.luluncotoapp.repository.CategoriaReporteRepository;
import com.puce.luluncotoapp.repository.ReporteRepository;
import com.puce.luluncotoapp.repository.UserRepository;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoriaReporteRepository categoriaRepository;

    @Autowired
    private HistorialActividadService historialService;

    private UserModel obtenerUsuarioAutenticado() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsuarioNoEncontradoException("Usuario no encontrado"));
    }

    private ReporteResponse convertirAResponse(ReporteModel reporte) {
        return new ReporteResponse(
            reporte.getId(),
            reporte.getTitulo(),
            reporte.getDescripcion(),
            reporte.getFotoUrl(),
            reporte.getLatitud(),
            reporte.getLongitud(),
            reporte.getEstado(),
            reporte.getCategoria().getNombre(),
            reporte.getCategoria().getId(),
            reporte.getUsuario().getNombre(),
            reporte.getUsuario().getId(),
            reporte.getCreadoEn(),
            reporte.getActualizadoEn()
        );
    }

    public ReporteResponse crearReporte(CrearReporteRequest request) {
        UserModel usuario = obtenerUsuarioAutenticado();

        if ("ADMIN".equals(usuario.getRol().getNombre())) {
            throw new AccesoDenegadoException("Los administradores no pueden crear reportes, solo los ciudadanos");
        }

        CategoriaReporteModel categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Categoría no encontrada"));

        ReporteModel reporte = new ReporteModel();
        reporte.setTitulo(request.getTitulo());
        reporte.setDescripcion(request.getDescripcion());
        reporte.setFotoUrl(request.getFotoUrl());
        reporte.setLatitud(request.getLatitud());
        reporte.setLongitud(request.getLongitud());
        reporte.setCategoria(categoria);
        reporte.setUsuario(usuario);

        ReporteModel reporteGuardado = reporteRepository.save(reporte);
        historialService.registrarActividad(usuario, "CREAR_REPORTE", "REPORTE", reporteGuardado.getId(), "Reporte creado: " + reporteGuardado.getTitulo() + " - Categoría: " + categoria.getNombre());
        return convertirAResponse(reporteGuardado);
    }

    public List<ReporteResponse> obtenerMisReportes() {
        UserModel usuario = obtenerUsuarioAutenticado();
        return reporteRepository.findByUsuarioIdOrderByCreadoEnDesc(usuario.getId())
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    public ReporteResponse obtenerReportePorId(Long id) {
        ReporteModel reporte = reporteRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Reporte no encontrado"));
        return convertirAResponse(reporte);
    }

    public List<ReporteResponse> obtenerTodosLosReportes() {
        return reporteRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    public List<ReporteResponse> obtenerReportesPorEstado(String estado) {
        return reporteRepository.findByEstado(estado)
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    public List<ReporteResponse> obtenerReportesPorCategoria(Long categoriaId) {
        return reporteRepository.findByCategoriaId(categoriaId)
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    public ReporteResponse actualizarEstado(Long reporteId, String nuevoEstado) {
        UserModel usuario = obtenerUsuarioAutenticado();

        if (!"ADMIN".equals(usuario.getRol().getNombre())) {
            throw new AccesoDenegadoException("Solo los administradores pueden cambiar el estado de un reporte");
        }

        ReporteModel reporte = reporteRepository.findById(reporteId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Reporte no encontrado"));
        reporte.setEstado(nuevoEstado);
        ReporteModel reporteActualizado = reporteRepository.save(reporte);
        historialService.registrarActividad(usuario, "CAMBIAR_ESTADO", "REPORTE", reporteActualizado.getId(), "Estado cambiado a: " + nuevoEstado);
        return convertirAResponse(reporteActualizado);
    }
}
