package com.hospital_vm.cl.hospital_vm.repository;

import com.hospital_vm.cl.hospital_vm.dto.AtencionReporteDTO;
import com.hospital_vm.cl.hospital_vm.model.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Integer> {
    @Query("SELECT new com.hospital_vm.cl.hospital_vm.dto.AtencionReporteDTO(a.horaAtencion, a.costo, a.medico.nombre, a.motivoConsulta) " +
            "FROM Atencion a WHERE a.paciente.id = :pacienteId")
    List<AtencionReporteDTO> findAtencionesByPacienteId(int pacienteId);
}
