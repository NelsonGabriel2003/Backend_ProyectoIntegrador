package com.puce.luluncotoapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puce.luluncotoapp.dto.HistorialResponse;
import com.puce.luluncotoapp.model.HistorialActividadModel;
import com.puce.luluncotoapp.model.UserModel;
import com.puce.luluncotoapp.repository.HistorialActividadRepository;

@Service
public class HistorialActividadService {

    @Autowired
    private HistorialActividadRepository historialRepository;

    public void registrarActividad(UserModel usuario, String accion, String entidad, Long entidadId, String detalle) {
        HistorialActividadModel registro = new HistorialActividadModel();
        registro.setUsuario(usuario);
        registro.setAccion(accion);
        registro.setEntidad(entidad);
        registro.setEntidadId(entidadId);
        registro.setDetalle(detalle);
        historialRepository.save(registro);
    }

    private HistorialResponse convertirAResponse(HistorialActividadModel registro) {
        return new HistorialResponse(
            registro.getId(),
            registro.getUsuario() != null ? registro.getUsuario().getNombre() : "Sistema",
            registro.getUsuario() != null ? registro.getUsuario().getId() : null,
            registro.getAccion(),
            registro.getEntidad(),
            registro.getEntidadId(),
            registro.getDetalle(),
            registro.getFechaHora()
        );
    }

    public List<HistorialResponse> obtenerTodoElHistorial() {
        return historialRepository.findAllByOrderByFechaHoraDesc()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    public List<HistorialResponse> obtenerHistorialPorUsuario(Long usuarioId) {
        return historialRepository.findByUsuarioIdOrderByFechaHoraDesc(usuarioId)
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    public List<HistorialResponse> obtenerHistorialPorEntidad(String entidad, Long entidadId) {
        return historialRepository.findByEntidadAndEntidadIdOrderByFechaHoraDesc(entidad, entidadId)
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }
}
