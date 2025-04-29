package com.hospital_vm.cl.hospital_vm.controller;

import com.hospital_vm.cl.hospital_vm.model.Medico;
import com.hospital_vm.cl.hospital_vm.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @PostMapping("/medicos")
    public Medico crearMedico(@RequestBody Medico medico) {
        return medicoService.crearMedico(medico);
    }

    @GetMapping("/medicos/{id}")
    public Medico obtenerMedicoPorId(@PathVariable int id) {
        return medicoService.obtenerMedicoPorId(id);
    }

    @PutMapping("/medicos/{id}")
    public Medico actualizarMedico(@PathVariable int id, @RequestBody Medico medico) {
        return medicoService.actualizarMedico(id, medico);
    }

    @DeleteMapping("/medicos/{id}")
    public void eliminarMedico(@PathVariable int id) {
        medicoService.eliminarMedico(id);
    }
}
