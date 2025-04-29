package com.hospital_vm.cl.hospital_vm.service;

import com.hospital_vm.cl.hospital_vm.dto.AtencionReporteDTO;
import com.hospital_vm.cl.hospital_vm.model.Atencion;
import com.hospital_vm.cl.hospital_vm.model.Medico;
import com.hospital_vm.cl.hospital_vm.model.Paciente;
import com.hospital_vm.cl.hospital_vm.repository.AtencionRepository;
import com.hospital_vm.cl.hospital_vm.repository.MedicoRepository;
import com.hospital_vm.cl.hospital_vm.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AtencionService {
    @Autowired
    private AtencionRepository atencionRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public Atencion crearAtencion(Atencion atencion, int pacienteId, int medicoId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Medico medico = medicoRepository.findById(medicoId)
                .orElseThrow(() -> new RuntimeException("Medico no encontrado"));

        atencion.setPaciente(paciente);
        atencion.setMedico(medico);

        return atencionRepository.save(atencion);
    }

    public List<Atencion> listarAtenciones() {
        return atencionRepository.findAll();
    }

    public List<AtencionReporteDTO> listarAtencionesPorPaciente(int pacienteId) {
        return atencionRepository.findAtencionesByPacienteId(pacienteId);
    }
}
