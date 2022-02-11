package com.example.prctice.Repository;

import com.example.prctice.Entity.Childrens;
import com.example.prctice.util.UUIDGenerator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildrensRepository extends JpaRepository<Childrens, UUIDGenerator> {
}
