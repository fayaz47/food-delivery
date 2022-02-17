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

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        //    List<Childrens> list = childrensRepository.findAll().stream().map(addChildrens::new).collect(Collectors.toList());
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

    public List<Childrens> addChildrens() {
         Childrens childrens = new Childrens();
        List<Integer> integers = Arrays.asList(1,12,433,5);

        Optional<Integer> max = integers.stream().reduce( Math::max );

        max.ifPresent(value -> System.out.println(value));
        List<Integer> list =  IntStream.range(1,10).boxed().collect(Collectors.toCollection(ArrayList::new));
        List<Long> collect = list.stream().map(Integer::longValue).collect(Collectors.toList());
        Stream<Long> sorted = collect.stream().sorted((s1, s2) -> s1.compareTo(s2));
        System.out.println(sorted);
        childrens.setName("fayaz");
         List<Childrens> childrensList = new ArrayList<Childrens>(10);
         childrensList.add(childrens);
        return childrensList;
    }
}
