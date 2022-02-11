package com.example.prctice.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Dinosur extends BaseIdentity {

//    @Id
//    @GeneratedValue(generator = "uuidGenerator")
//    @GenericGenerator(name = "uuidGenerator", strategy = "com.example.prctice.util.UUIDGenerator")
//    private UUID id;

    private String name;

    private boolean fangs;

    private int numberOfArms;

    private double weightTons;

    @OneToMany(mappedBy = "dinosur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  // @OneToMany(mappedBy = "parent", orphanRemoval = true)
   // @OneToMany(mappedBy = "dinosur")
   @JsonManagedReference
    private List<Childrens> childrens = new ArrayList<>();


    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', fangs='%b', numberOfArms='%d', weightTons='%f']",
                getId(), name, fangs, numberOfArms, weightTons);
    }
}
