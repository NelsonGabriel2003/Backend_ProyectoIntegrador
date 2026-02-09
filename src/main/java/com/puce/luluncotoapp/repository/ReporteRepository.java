package com.puce.luluncotoapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.puce.luluncotoapp.model.ReporteModel;

public interface ReporteRepository extends JpaRepository<ReporteModel, Long> {
    List<ReporteModel> findByUsuarioId(Long usuarioId);
    List<ReporteModel> findByEstado(String estado);
    List<ReporteModel> findByCategoriaId(Long categoriaId);
    List<ReporteModel> findByUsuarioIdOrderByCreadoEnDesc(Long usuarioId);

    @Query("SELECT r.categoria.nombre, COUNT(r) FROM ReporteModel r GROUP BY r.categoria.nombre")
    List<Object[]> contarReportesPorCategoria();

    @Query("SELECT r.estado, COUNT(r) FROM ReporteModel r GROUP BY r.estado")
    List<Object[]> contarReportesPorEstado();

    long count();
}
