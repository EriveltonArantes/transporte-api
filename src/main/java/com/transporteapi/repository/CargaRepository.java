package com.transporteapi.repository;

import com.transporteapi.model.Carga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargaRepository extends JpaRepository<Carga, Long> {
}
