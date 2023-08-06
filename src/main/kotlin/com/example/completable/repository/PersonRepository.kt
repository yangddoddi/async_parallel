package com.example.completable.repository

import com.example.completable.domain.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long> {
    fun findByName(name: String): Person?
}