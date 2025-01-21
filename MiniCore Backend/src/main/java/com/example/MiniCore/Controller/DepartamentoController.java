package com.example.MiniCore.Controller;

import com.example.MiniCore.Models.Departamento;
import com.example.MiniCore.Service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
    @Autowired
    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping("/info")
    public String index(){
        return "Conectado a la tabla de Departamentos";
    }

    @GetMapping()
    public List<Departamento> getAllDepartamentos(){
        return departamentoService.findAll();
    }

    @PostMapping()
    public ResponseEntity<String> registrarDepartamento(@RequestBody Departamento departamento){
        departamentoService.crearDepartamento(departamento);
        return ResponseEntity.ok("Registro de departamento exitoso");
    }
}
