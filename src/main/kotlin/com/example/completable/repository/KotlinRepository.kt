package com.example.completable.repository

import com.example.completable.domain.Kotlin
import org.springframework.data.jpa.repository.JpaRepository

interface KotlinRepository : JpaRepository<Kotlin, Long> {
}