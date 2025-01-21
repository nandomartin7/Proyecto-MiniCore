package com.example.MiniCore.Repository;

import com.example.MiniCore.Models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento,Long> {
    Departamento findByIdDepartamento(Long id);
}
