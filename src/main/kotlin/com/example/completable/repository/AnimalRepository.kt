package com.example.completable.repository

import com.example.completable.domain.Animal
import org.springframework.data.jpa.repository.JpaRepository

interface AnimalRepository : JpaRepository<Animal, Long> {
}