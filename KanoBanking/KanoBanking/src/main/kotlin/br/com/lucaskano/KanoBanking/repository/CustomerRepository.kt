package br.com.lucaskano.KanoBanking.repository

import br.com.lucaskano.KanoBanking.domain.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, Int>