package com.example.prctice.controller;

import com.example.prctice.Entity.Childrens;
import com.example.prctice.Repository.DinosurRepository;
import com.example.prctice.models.Orphans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class ChildrensController {

    @Autowired
    DinosurRepository dinosurRepository;
   // private Function<? super Childrens,?> getOrphans;

    @GetMapping("/childrenNames")
    public ResponseEntity<List<String>> geteChildrenNames() {
        try {
            return new ResponseEntity<>(dinosurRepository.getChildrenNames(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/childrensMaleList")
    public ResponseEntity<List<Childrens>> getmaleChildrens() {
        try {
             List<Childrens> maleChildrens = dinosurRepository.getChildrens().stream().filter(e -> e.isMale()).collect(Collectors.toList());
            return new ResponseEntity<>(maleChildrens, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/childrensFemaleList")
    public ResponseEntity<List<Childrens>> getfemaleChildrens() {
        try {
            List<Childrens> femaleChildrens = dinosurRepository.getChildrens().stream().filter(e -> !e.isMale()).collect(Collectors.toList());
            return new ResponseEntity<>(femaleChildrens, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/orphanssList")
    public ResponseEntity<List<Orphans>> geteOrphans() {
        try {
            List<Orphans> orphans = dinosurRepository.getChildrens().stream().filter(e -> e.isMale()).map(ChildrensController::getOrphans).collect(Collectors.toList());
            orphans = dinosurRepository.getChildrens().stream().filter(e -> e.isMale()).map(Orphans::new).collect(Collectors.toList());

            return new ResponseEntity<>(orphans, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public static Orphans getOrphans(Childrens childrens) {
       return new Orphans(childrens);
    }
}