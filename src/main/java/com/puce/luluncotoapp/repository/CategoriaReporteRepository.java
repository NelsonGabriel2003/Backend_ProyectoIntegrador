package com.puce.luluncotoapp.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.puce.luluncotoapp.model.CategoriaReporteModel;

public interface CategoriaReporteRepository extends JpaRepository<CategoriaReporteModel, Long> {
    Optional<CategoriaReporteModel> findByNombre(String nombre);
    List<CategoriaReporteModel> findByEsPredefinida(boolean esPredefinida);
}
