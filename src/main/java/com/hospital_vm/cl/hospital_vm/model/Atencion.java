package com.hospital_vm.cl.hospital_vm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "atencion")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Date fechaAtencion;

    @Column(nullable = false)
    private String horaAtencion;

    @Column(nullable = false, length = 500)
    private String motivoConsulta;

    @Column(nullable = false)
    private Double costo;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

}
