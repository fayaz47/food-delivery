package com.example.prctice.Entity;

import com.example.prctice.util.CompositAId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
public class Animal {

    @EmbeddedId
    private CompositAId compositAId;

    @Basic
    private ZonedDateTime birthDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("dogId")
    private Dog dog;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("catId")
    private Cat cat;
}
