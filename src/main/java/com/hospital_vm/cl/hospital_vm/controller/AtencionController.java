package com.hospital_vm.cl.hospital_vm.controller;

import com.hospital_vm.cl.hospital_vm.dto.AtencionReporteDTO;
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

    @GetMapping("/reporte/atenciones")
    public ResponseEntity<List<AtencionReporteDTO>> obtenerReportePorPaciente(@RequestParam("paciente") int pacienteId) {
        List<AtencionReporteDTO> reporte = atencionService.listarAtencionesPorPaciente(pacienteId);
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

    @GetMapping("/atenciones")
    public ResponseEntity<List<Atencion>> listarAtenciones() {
        return ResponseEntity.ok(atencionService.listarAtenciones());
    }
}
