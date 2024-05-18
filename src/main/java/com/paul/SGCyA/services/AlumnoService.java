package com.paul.SGCyA.services;

import com.paul.SGCyA.models.Alumno;

import java.util.List;

public interface AlumnoService {
    public List<Alumno> findAll();
    public Alumno findByMatricula(String matricula);
    public Alumno createAlumno(Alumno alumno);
    public Alumno updateAlumno(Alumno alumno);
    public Boolean deleteAlumno(Long id);
}
