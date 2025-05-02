package com.hospital_vm.cl.hospital_vm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MedicoReporteDTO {

    private Date fechaAtencion;
    private String horaAtencion;
    private Double costo;
    private String nombrePaciente;
    private String motivoConsulta;

    public MedicoReporteDTO(Date fechaAtencion, String horaAtencion, Double costo, String nombrePaciente, String motivoConsulta) {
        this.fechaAtencion = fechaAtencion;
        this.horaAtencion = horaAtencion;
        this.costo = costo;
        this.nombrePaciente = nombrePaciente;
        this.motivoConsulta = motivoConsulta;
    }
}
