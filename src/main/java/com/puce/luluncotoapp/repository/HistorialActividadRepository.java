package com.puce.luluncotoapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.puce.luluncotoapp.model.HistorialActividadModel;

public interface HistorialActividadRepository extends JpaRepository<HistorialActividadModel, Long> {
    List<HistorialActividadModel> findByUsuarioIdOrderByFechaHoraDesc(Long usuarioId);
    List<HistorialActividadModel> findByEntidadAndEntidadIdOrderByFechaHoraDesc(String entidad, Long entidadId);
    List<HistorialActividadModel> findAllByOrderByFechaHoraDesc();
    List<HistorialActividadModel> findByAccionOrderByFechaHoraDesc(String accion);
}
