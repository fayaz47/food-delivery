package com.example.prctice.models;

import com.example.prctice.Entity.Childrens;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orphans {
    private String name;
    private String city;
    private int age;
    public Orphans(Childrens childrens) {
        this.name = childrens.getName();
        this.city = "Devanakonda";
        this.age = childrens.getDinosur().getNumberOfArms();
    }
}
