package com.example.prctice.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Childrens extends BaseIdentity {


//    @Id
//    @GeneratedValue(generator = "uuidGenerator")
//    @GenericGenerator(name = "uuidGenerator", strategy = "com.example.prctice.util.UUIDGenerator")
//    private UUID id;

    private String name;

    private boolean male;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "dinosur_id", nullable = false)
    private Dinosur dinosur;

}
