package com.example.prctice.Repository.impl;

import com.example.prctice.Entity.Childrens;
import com.example.prctice.Entity.Dinosur;
import com.example.prctice.Repository.DinosurRepositoryEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class DinosurRepositoryEntityManagerImpl implements DinosurRepositoryEntityManager {

    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public Dinosur saveDinosur(Dinosur dinosur) {
      em.persist(dinosur);
        return dinosur;
    }

    @Override
    public List<String> getChildrenNames() {


        return (List<String>) em.createNativeQuery(
                "SELECT name FROM childrens GROUP BY name"
        ).getResultList();


    }
    @Override
    public List<Childrens> getChildrens() {


        return  (List<Childrens>) em.createNativeQuery(
                "SELECT *  FROM childrens GROUP BY id",Childrens.class
        ).getResultList();


    }
}


