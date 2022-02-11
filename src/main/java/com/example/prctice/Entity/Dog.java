package com.example.prctice.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Dog extends BaseIdentity{

    @OneToOne(optional = true)
    private Childrens childrens;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "dog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animal> animal = new ArrayList<>();
}
