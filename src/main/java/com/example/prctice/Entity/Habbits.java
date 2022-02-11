package com.example.prctice.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Habbits extends BaseIdentity{


    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "com.example.prctice.util.UUIDGenerator")
    private UUID id;

    private String name;

    @ManyToMany
    private List<Childrens> childrens;
}
