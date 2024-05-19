package com.paul.SGCyA.services.impl;

import com.paul.SGCyA.models.Alumno;
import com.paul.SGCyA.models.Curso;
import com.paul.SGCyA.models.Enrolado;
import com.paul.SGCyA.repositories.EnroladoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnroladosServiceImpl {

    @Autowired
    EnroladoRepository enroladoRepository;

    public Enrolado saveEnrolado(Enrolado enrolado){
        return enroladoRepository.save(enrolado);
    }

    public boolean updateEnrolado(Enrolado enrolado){
        if(enroladoRepository.existsById(enrolado.getId())){
            enroladoRepository.save(enrolado);
            return true;
        }
        return false;
    }

    public boolean deleteEnrolado(Long id){
        if(enroladoRepository.existsById(id)){
            enroladoRepository.deleteById(id);
            return true;
        }else {
            new RuntimeException("no este enrolamiento");
        }
        return false;
    }
}
