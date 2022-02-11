package com.example.prctice.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public interface Identifiable {
     UUID getId();
}
