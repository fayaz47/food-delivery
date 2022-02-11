package com.example.prctice;

import com.example.prctice.Entity.Childrens;
import com.example.prctice.Entity.Habbits;
import com.example.prctice.Repository.ChildrensRepository;
import com.example.prctice.Repository.HabbitsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HabbitsController {

    @Autowired
    HabbitsRespository habbitsRespository;
    @GetMapping("/habbits")
    public ResponseEntity<List<Habbits>> geteTutorial() {
        try {
//            Dinosur _tutorial = tutorialRepository
//                    .save(new Dinosur(UUID.randomUUID(),tutorial.getName(), true, tutorial.getNumberOfArms(), tutorial.getWeightTons()));
            List<Habbits> childrens = new ArrayList<Habbits>();
            habbitsRespository.
            findAll().forEach(childrens::add);
            return new ResponseEntity<>(childrens, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/habbits")
    public ResponseEntity<Habbits> createTutorial(@RequestBody Habbits tutorial) {
        try {
//            Dinosur _tutorial = tutorialRepository
//                    .save(new Dinosur(UUID.randomUUID(),tutorial.getName(), true, tutorial.getNumberOfArms(), tutorial.getWeightTons()));

            Habbits _tutorial = habbitsRespository
                    .save(tutorial);
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
