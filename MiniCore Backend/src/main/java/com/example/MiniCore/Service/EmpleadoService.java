package com.example.MiniCore.Service;

import com.example.MiniCore.Models.Empleado;
import com.example.MiniCore.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> findAll(){
        return empleadoRepository.findAll();
    }

    public Empleado crearEmpleado(Empleado empleado){
        empleadoRepository.save(empleado);
        return empleado;
    }

    public Empleado findById(Long idEmpleado){
        return empleadoRepository.findByIdEmpleado(idEmpleado);
    }
}
