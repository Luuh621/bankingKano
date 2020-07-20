package br.com.lucaskano.KanoBanking.service

import br.com.lucaskano.KanoBanking.domain.entities.Customer
import br.com.lucaskano.KanoBanking.dto.CustomerDTO
import org.springframework.stereotype.Service

@Service
interface CustomerService {

    fun findById(id: Int) : CustomerDTO

    fun save(customer: Customer)

    fun listAll() : List<CustomerDTO>

    fun updateById(id: Int, customer: Customer) : Customer

    fun deleteById(id: Int)
}