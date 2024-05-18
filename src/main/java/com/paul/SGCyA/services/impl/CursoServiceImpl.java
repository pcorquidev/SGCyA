package com.paul.SGCyA.services.impl;

import com.paul.SGCyA.models.Curso;
import com.paul.SGCyA.repositories.CursosRespository;
import com.paul.SGCyA.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    CursosRespository cursosRespository;

    public List<Curso> findAll(){
        return cursosRespository.findAll();
    }

    public Curso findByName(String name){
        return cursosRespository.findByName(name);
    }

    public boolean exist(Long id){
        return cursosRespository.existsById(id);
    }

    public Curso saveCurso(Curso curso){
        return cursosRespository.save(curso);
    }

    public Curso updateCurso(Curso curso){
        Curso c = cursosRespository.findById(curso.getId()).get();
        return cursosRespository.save(c);
    }

    public boolean deleteCurso(Long id){
        if(exist(id)){
            cursosRespository.deleteById(id);
            return true;
        }else{
            new RuntimeException("el curso no existe");
        }
        return false;
    }
}
