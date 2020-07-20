package br.com.lucaskano.KanoBanking.service

import br.com.lucaskano.KanoBanking.domain.entities.Customer
import br.com.lucaskano.KanoBanking.dto.CustomerDTO
import br.com.lucaskano.KanoBanking.repository.CustomerRepository
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
data class CustomerServiceImpl(@Autowired val customerRepository: CustomerRepository) : CustomerService {

    override fun findById(id: Int) = toDTO(customerRepository.findById(id).orElse(null))

    override fun save(customer: Customer) {
        customerRepository.save(customer)
    }

    override fun listAll(): List<CustomerDTO> = customerRepository.findAll().
    map { customer -> CustomerDTO(customer.id, customer.name, customer.document) }

    override fun updateById(id: Int, newCustomer: Customer): Customer {
        if (checkIfExists(id)) {
            val oldCustomer = customerRepository.findById(id)
            val customer = oldCustomer.get()
            customer.name = newCustomer.name
            customer.document = newCustomer.document
            return customerRepository.save(customer)
        } else {
            throw br.com.lucaskano.KanoBanking.service.exception.NotFoundException("Customer not found!")
        }
    }

    override fun deleteById(id: Int) {
        if(checkIfExists(id)){
            customerRepository.deleteById(id)
        }
    }

    fun checkIfExists(id: Int): Boolean {
        val customer = customerRepository.findById(id)
        if (customer.isPresent())
            return true
        return false
    }

    fun fromDTO(customerDTO: CustomerDTO) = Customer(customerDTO.id, customerDTO.name, customerDTO.document)

    fun toDTO(customer: Customer) = CustomerDTO(customer.id, customer.name, customer.document)
}