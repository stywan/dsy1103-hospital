package com.hospital_vm.cl.hospital_vm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AtencionReporteDTO {

    private String horaAtencion;
    private double costo;
    private String nombreMedico;
    private String motivoConsulta;

    public AtencionReporteDTO(String horaAtencion, double costo, String nombreMedico, String motivoConsulta) {
        this.horaAtencion = horaAtencion;
        this.costo = costo;
        this.nombreMedico = nombreMedico;
        this.motivoConsulta = motivoConsulta;
    }
}
