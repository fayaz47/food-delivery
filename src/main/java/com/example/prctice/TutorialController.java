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

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class TutorialController {
    @Autowired
    DinosurRepository tutorialRepository;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Dinosur>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Dinosur> tutorials = new ArrayList<Dinosur>();
            if (title == null)
                tutorialRepository.findAll().forEach(tutorials::add);
            else
                tutorialRepository.findByNameContaining(title).forEach(tutorials::add);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/tutorials")
    public ResponseEntity<Dinosur> createTutorial(@RequestBody Dinosur tutorial) {
        try {
//            Dinosur _tutorial = tutorialRepository
//                    .save(new Dinosur(UUID.randomUUID(),tutorial.getName(), true, tutorial.getNumberOfArms(), tutorial.getWeightTons()));

            Dinosur _tutorial = tutorialRepository
                    .save(tutorial);
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/tutorials")
    public ResponseEntity<Dinosur> deleteTutorial(@RequestParam UUID tutorial) {
        try {
//            Dinosur _tutorial = tutorialRepository
//                    .save(new Dinosur(UUID.randomUUID(),tutorial.getName(), true, tutorial.getNumberOfArms(), tutorial.getWeightTons()));

             tutorialRepository
                    .deleteById(tutorial);
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}