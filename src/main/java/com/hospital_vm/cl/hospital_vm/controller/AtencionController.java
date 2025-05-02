package com.hospital_vm.cl.hospital_vm.controller;

import com.hospital_vm.cl.hospital_vm.dto.AtencionReporteDTO;
import com.hospital_vm.cl.hospital_vm.dto.MedicoReporteDTO;
import com.hospital_vm.cl.hospital_vm.model.Atencion;
import com.hospital_vm.cl.hospital_vm.service.AtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AtencionController {
    @Autowired
    private AtencionService atencionService;

    @GetMapping("/atenciones")
    public ResponseEntity<List<Atencion>> listarAtenciones() {
        return ResponseEntity.ok(atencionService.listarAtenciones());
    }


    @GetMapping("/reportes/atenciones")
    public ResponseEntity<?> obtenerReporte(
            @RequestParam(required = false) Integer paciente,
            @RequestParam(required = false) Integer medico) {

        if (paciente != null) {
            List<AtencionReporteDTO> reportePaciente = atencionService.listarAtencionesPorPaciente(paciente);
            return ResponseEntity.ok(reportePaciente);
        } else if (medico != null) {
            List<MedicoReporteDTO> reporteMedico = atencionService.listarAtencionesPorMedico(medico);
            return ResponseEntity.ok(reporteMedico);
        } else {
            return ResponseEntity.badRequest().body("Debe especificar el parámetro 'paciente' o 'medico'.");
        }
    }

    
    @GetMapping("/reporte/medico")
    public ResponseEntity<List<MedicoReporteDTO>> obtenerReportePorMedico(@RequestParam("medico") int medicoId) {
        List<MedicoReporteDTO> reporte = atencionService.listarAtencionesPorMedico(medicoId);
        return ResponseEntity.ok(reporte);
    }

    @PostMapping("/atenciones/{pacienteId}/{medicoId}")
    public ResponseEntity<Atencion> crearAtencion(
            @RequestBody Atencion atencion,
            @PathVariable int pacienteId,
            @PathVariable int medicoId) {
        Atencion nuevaAtencion = atencionService.crearAtencion(atencion, pacienteId, medicoId);
        return ResponseEntity.ok(nuevaAtencion);
    }
}
