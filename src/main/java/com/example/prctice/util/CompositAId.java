package com.example.prctice.util;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CompositAId implements Serializable {
    @Column(name = "dog_id")
    private UUID animalId;

    @Column(name= "cat_id")
    private UUID breedId;


}
