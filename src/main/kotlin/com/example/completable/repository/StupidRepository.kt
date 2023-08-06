package com.example.completable.repository

import com.example.completable.domain.Stupid
import org.springframework.data.jpa.repository.JpaRepository

interface StupidRepository : JpaRepository<Stupid, Long> {
}