package com.example.completable.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val price: Int
) {
    companion object {
        fun fixture(
            name: String = "name",
            price: Int = 10
        ): Product {
            return Product(
                name = name,
                price = price
            )
        }
    }
}