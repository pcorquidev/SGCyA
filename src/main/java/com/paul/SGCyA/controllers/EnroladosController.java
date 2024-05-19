package com.paul.SGCyA.controllers;

import com.paul.SGCyA.models.Enrolado;
import com.paul.SGCyA.services.impl.EnroladosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enrolados")
public class EnroladosController {

    @Autowired
    EnroladosServiceImpl enroladosService;


    @PostMapping
    public ResponseEntity<Enrolado> enrollar(@RequestBody Enrolado enrolado){
        return ResponseEntity.ok(enroladosService.saveEnrolado(enrolado));
    }

    @PutMapping
    public ResponseEntity<Void> updateEnrolado(@RequestBody Enrolado enrolado){
        if(enroladosService.updateEnrolado(enrolado)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> baja(@PathVariable Long id){
        if(enroladosService.deleteEnrolado(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
