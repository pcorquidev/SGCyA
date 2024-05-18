package com.paul.SGCyA.controllers;

import com.paul.SGCyA.models.Alumno;
import com.paul.SGCyA.services.AlumnoService;
import com.paul.SGCyA.services.impl.AlumnosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnosController {

    @Autowired
    AlumnosServiceImpl alumnosService;

    @GetMapping
    public ResponseEntity<List<Alumno>> getAllAlumnos(){
        return ResponseEntity.ok(alumnosService.findAll());
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Alumno> getAlumnoByMatricula(@PathVariable String matricula){
        return ResponseEntity.ok(alumnosService.findByMatricula(matricula));
    }

    @PostMapping
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno){
        return ResponseEntity.ok(alumnosService.createAlumno(alumno));
    }

    @PutMapping
    public ResponseEntity<Alumno> updateAlumno(@RequestBody Alumno alumno){
        if(alumno.getId() != null ){
            if(alumnosService.alumnoexists(alumno.getId())){
                return ResponseEntity.ok(alumnosService.updateAlumno(alumno));
            }
        }
         return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idAlumno}")
    public ResponseEntity<?> deleteAlumno(@PathVariable Long idAlumno){
        if(alumnosService.alumnoexists(idAlumno)){
            alumnosService.deleteAlumno(idAlumno);
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.badRequest().build();
    }

}
