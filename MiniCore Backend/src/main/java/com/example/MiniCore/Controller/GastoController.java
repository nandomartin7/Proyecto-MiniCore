package com.example.MiniCore.Controller;

import com.example.MiniCore.Models.Departamento;
import com.example.MiniCore.Models.Gasto;
import com.example.MiniCore.Service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gasto")
public class GastoController {
    @Autowired
    private final GastoService gastoService;

    public GastoController(GastoService gastoService) {
        this.gastoService = gastoService;
    }

    @GetMapping("/info")
    public String index(){
        return "Conectado a la tabla de Gastos";
    }

    @GetMapping()
    public List<Gasto> getAllGasto(){
        return gastoService.findAll();
    }

    @PostMapping()
    public ResponseEntity<String> registrarGasto(@RequestBody Gasto gasto){
        gastoService.registrarGasto(gasto);
        return ResponseEntity.ok("Registro de gasto exitoso");
    }

    @PutMapping("/{idGasto}")
    public ResponseEntity<Gasto> actualizarGasto(@PathVariable Long id, @RequestBody Gasto gasto){
        Gasto actualizado = gastoService.update(id,gasto);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idGasto}")
    public ResponseEntity<Void> eliminarGasto (@PathVariable Long id){
        return gastoService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/filtrar")
    public Map<String, List<Gasto>> ListarDepartamentosConGastos (
            @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd")Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd")Date fechaFin){

        List<Gasto> gastosEnRango = gastoService.findAll().stream()
                .filter(gasto -> gasto.getFecha().compareTo(fechaInicio)>=0 && gasto.getFecha().compareTo(fechaFin)<=0)
                .collect(Collectors.toList());

        Map<String, List<Gasto>> departamentosGastosMap = new HashMap<>();

        for (Gasto gasto : gastosEnRango){
            Departamento departamento = gasto.getDepartamento();

            if (departamento != null){
                //Crear una clave única para cada departamento
                String departamentoKey = departamento.getNombre();

                //Si ya existe una entrada para este departamento, añade el gasto a la lista
                departamentosGastosMap.putIfAbsent(departamentoKey, new ArrayList<>());
                departamentosGastosMap.get(departamentoKey).add(gasto);
            }
        }
        return departamentosGastosMap;
    }
}
