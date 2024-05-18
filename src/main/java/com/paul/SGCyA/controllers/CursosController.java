package com.paul.SGCyA.controllers;

import com.paul.SGCyA.models.Curso;
import com.paul.SGCyA.services.impl.CursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursosController {

    @Autowired
    CursoServiceImpl cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> getAllCursos(){
        return new ResponseEntity<>(cursoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Curso> getCurso(@PathVariable String name){
        return ResponseEntity.ok(cursoService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso){
        return new ResponseEntity<Curso>(cursoService.saveCurso(curso),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso){
        if(curso.getId() == null || !cursoService.exist(curso.getId())){
            return ResponseEntity.ok(cursoService.updateCurso(curso));
        }
        return  ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id){
        if(cursoService.deleteCurso(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
