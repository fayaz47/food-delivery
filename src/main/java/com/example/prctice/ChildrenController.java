package com.example.prctice;

import com.example.prctice.Entity.Childrens;
import com.example.prctice.Entity.Dinosur;
import com.example.prctice.Repository.ChildrensRepository;
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
public class ChildrenController {

    @Autowired
    ChildrensRepository childrensRepository;
    @GetMapping("/childrens")
    public ResponseEntity<List<Childrens>> geteTutorial() {
        try {
//            Dinosur _tutorial = tutorialRepository
//                    .save(new Dinosur(UUID.randomUUID(),tutorial.getName(), true, tutorial.getNumberOfArms(), tutorial.getWeightTons()));
            List<Childrens> childrens = new ArrayList<Childrens>();
            childrensRepository.
            findAll().forEach(childrens::add);
            return new ResponseEntity<>(childrens, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/childrens")
    public ResponseEntity<Childrens> createTutorial(@RequestBody Childrens tutorial) {
        try {
//            Dinosur _tutorial = tutorialRepository
//                    .save(new Dinosur(UUID.randomUUID(),tutorial.getName(), true, tutorial.getNumberOfArms(), tutorial.getWeightTons()));

            Childrens _tutorial = childrensRepository
                    .save(tutorial);
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
