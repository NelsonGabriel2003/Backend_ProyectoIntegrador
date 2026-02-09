package com.puce.luluncotoapp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.puce.luluncotoapp.model.RolModel;

public interface RolRepository extends JpaRepository<RolModel, Long> {
    Optional<RolModel> findByNombre(String nombre);
}
