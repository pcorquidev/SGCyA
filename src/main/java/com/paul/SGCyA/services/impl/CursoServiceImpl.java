package com.paul.SGCyA.services.impl;

import com.paul.SGCyA.DTO.AlumnoDTO;
import com.paul.SGCyA.DTO.CursoDTO;
import com.paul.SGCyA.models.Curso;
import com.paul.SGCyA.repositories.CursosRespository;
import com.paul.SGCyA.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    CursosRespository cursosRespository;

    public List<Curso> findAll(){
        return cursosRespository.findAll();
    }

    public CursoDTO findByName(String name){

        Curso curso = cursosRespository.findByName(name);
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setNombreCurso(curso.getName());
        cursoDTO.setMatricula(curso.getClave());
        List<AlumnoDTO> alumnos;
        alumnos = curso.getEnrolados().stream().map(
                 enrolado -> {
                     AlumnoDTO alumnoDTO = new AlumnoDTO();
                     alumnoDTO.setNombreCompleto(enrolado.getAlumnos().getFirst_name() + " " +enrolado.getAlumnos().getLastName());
                     alumnoDTO.setMatricula(enrolado.getAlumnos().getMatricula());

                     if(enrolado.getCalificacion() != null || enrolado.getAsistencia() != null){
                         if(enrolado.getCalificacion() >= 7.0 || enrolado.getAsistencia() >= 80){
                             alumnoDTO.setAprobado("APROVADO");
                         }else {
                             alumnoDTO.setAprobado("NO APROVADO");
                         }
                     }else {
                         alumnoDTO.setAprobado("Sin Calificacion");
                     }
                     return alumnoDTO;
                 }
         ).collect(Collectors.toList());
         cursoDTO.setAlumnos(alumnos);
         return cursoDTO;
    }

    public boolean exist(Long id){
        return cursosRespository.existsById(id);
    }

    public Curso saveCurso(Curso curso){
        return cursosRespository.save(curso);
    }

    public boolean updateCurso(Curso curso){
        if(cursosRespository.existsById(curso.getId())){
            cursosRespository.save(curso);
            return true;
        }
        return false;
    }

    public boolean deleteCurso(Long id){
        if(exist(id)){
            cursosRespository.deleteById(id);
            return true;
        }
        return false;
    }
}
