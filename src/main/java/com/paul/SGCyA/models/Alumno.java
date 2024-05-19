package com.paul.SGCyA.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Table(name = "ALUMNOS")
@Entity(name = "ALUMNO")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String matricula;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion;

    @JsonIgnore
    @OneToMany(mappedBy = "alumnos")
    private List<Enrolado> enrolados;
}
