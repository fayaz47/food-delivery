package com.example.prctice.Repository;

import com.example.prctice.Entity.Childrens;
import com.example.prctice.Entity.Dinosur;

import java.util.List;

public interface DinosurRepositoryEntityManager {
    Dinosur saveDinosur(Dinosur dinosur);
    List<String> getChildrenNames();
    List<Childrens> getChildrens();
}
