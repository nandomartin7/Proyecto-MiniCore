package com.example.MiniCore.Controller;

import com.example.MiniCore.Models.Empleado;
import com.example.MiniCore.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/info")
    public String index(){
        return "Conectado a la tabla de Empleados";
    }

    @GetMapping()
    public List<Empleado> getAllEmpleado(){
        return empleadoService.findAll();
    }

    @PostMapping()
    public ResponseEntity<String> registrarEmpleado(@RequestBody Empleado empleado){
        empleadoService.crearEmpleado(empleado);
        return ResponseEntity.ok("Registro de empleado exitoso");
    }
}
