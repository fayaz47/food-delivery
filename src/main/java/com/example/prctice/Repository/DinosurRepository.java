package com.example.prctice.Repository;

import com.example.prctice.Entity.Dinosur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface DinosurRepository extends CrudRepository<Dinosur, UUID> {
    List<Dinosur> findByNameContaining(String name);
}
