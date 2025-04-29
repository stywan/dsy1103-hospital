package com.hospital_vm.cl.hospital_vm.service;

import com.hospital_vm.cl.hospital_vm.model.Medico;
import com.hospital_vm.cl.hospital_vm.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico crearMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    public Medico obtenerMedicoPorId(int id) {
        Optional<Medico> optionalMedico = medicoRepository.findById(id);
        return optionalMedico.orElseThrow(() -> new RuntimeException("Médico no encontrado con ID: " + id));
    }

    public Medico actualizarMedico(int id, Medico medicoActualizado) {
        Medico medicoExistente = obtenerMedicoPorId(id);

        medicoExistente.setNombre(medicoActualizado.getNombre());
        medicoExistente.setApellido(medicoActualizado.getApellido());
        medicoExistente.setRut(medicoActualizado.getRut());
        medicoExistente.setEspecialidad(medicoActualizado.getEspecialidad());
        medicoExistente.setJefeTurno(medicoActualizado.getJefeTurno());

        return medicoRepository.save(medicoExistente);
    }

    public void eliminarMedico(int id) {
        medicoRepository.deleteById(id);
    }

}
