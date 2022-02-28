package com.example.prctice;

import com.example.prctice.Entity.Dinosur;
import com.example.prctice.Repository.DinosurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DinosurController {
    @Autowired
    DinosurRepository dinosurRepository;

    @GetMapping("/dinosurs")
    public ResponseEntity<List<Dinosur>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Dinosur> tutorials = new ArrayList<Dinosur>();
            if (title == null)
                dinosurRepository.findAll().forEach(tutorials::add);
            else
                dinosurRepository.findByNameContaining(title).forEach(tutorials::add);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/dinosurs")
    public ResponseEntity<Dinosur> createTutorial(@RequestBody Dinosur tutorial) {
        try {
            Dinosur dinosur = dinosurRepository.saveDinosur(tutorial);
            return new ResponseEntity<>(dinosur, HttpStatus.CREATED);
//            Dinosur _tutorial = dinosurRepository
//                    .save(tutorial);
//
//            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/dinosurs")
    public ResponseEntity<Dinosur> deleteTutorial(@RequestParam UUID tutorial) {
        try {
//            Dinosur _tutorial = tutorialRepository
//                    .save(new Dinosur(UUID.randomUUID(),tutorial.getName(), true, tutorial.getNumberOfArms(), tutorial.getWeightTons()));

            dinosurRepository
                    .deleteById(tutorial);
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}