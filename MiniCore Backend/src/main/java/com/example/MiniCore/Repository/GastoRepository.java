package com.example.MiniCore.Repository;

import com.example.MiniCore.Models.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto,Long> {
    Gasto findByIdGasto(Long id);
}
