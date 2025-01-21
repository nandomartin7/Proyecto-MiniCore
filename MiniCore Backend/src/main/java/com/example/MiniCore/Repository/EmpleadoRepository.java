package com.example.MiniCore.Repository;

import com.example.MiniCore.Models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
    Empleado findByIdEmpleado(Long id);
}
