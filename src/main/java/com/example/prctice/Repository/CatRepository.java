package com.example.prctice.Repository;

import com.example.prctice.Entity.Cat;

import java.util.UUID;

public interface CatRepository extends CrudRepository<Cat, UUID> {
}
