package com.example.prctice.Repository;

import com.example.prctice.Entity.Dog;
import com.example.prctice.util.UUIDGenerator;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface DogRepository extends PagingAndSortingRepository<Dog, UUID> {
}
