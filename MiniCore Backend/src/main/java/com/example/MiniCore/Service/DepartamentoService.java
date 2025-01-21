package com.example.MiniCore.Service;

import com.example.MiniCore.Models.Departamento;
import com.example.MiniCore.Repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {
    @Autowired
    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public List<Departamento> findAll(){
        return departamentoRepository.findAll();
    }

    public Departamento crearDepartamento(Departamento departamento){
        departamentoRepository.save(departamento);
        return departamento;
    }

    public Departamento findById(Long idDepartamento){
        return departamentoRepository.findByIdDepartamento(idDepartamento);
    }
}
