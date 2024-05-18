package com.paul.SGCyA.services.impl;

import com.paul.SGCyA.models.Alumno;
import com.paul.SGCyA.repositories.AlumnosRepository;
import com.paul.SGCyA.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnosServiceImpl implements AlumnoService {

    @Autowired
    AlumnosRepository alumnosRepository;

    public List<Alumno> findAll(){
        return alumnosRepository.findAll();
    }

    public Alumno findByMatricula(String matricula){
        return alumnosRepository.findByMatricula(matricula);
    }

    public Boolean alumnoexists(Long id){
        return alumnosRepository.existsById(id);
    }

    public Alumno createAlumno(Alumno alumno){
        return alumnosRepository.save(alumno);
    }

    public Alumno updateAlumno(Alumno alumno){
        return alumnosRepository.save(alumno);
    }

    public Boolean deleteAlumno(Long id){
        if(alumnoexists(id)){
            alumnosRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
