package com.example.completable.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Animal(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val age: Int
) {
    companion object {
        fun fixture(
            name: String = "name",
            age: Int = 10
        ): Animal {
            return Animal(
                name = name,
                age = age
            )
        }
    }
}