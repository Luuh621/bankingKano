package br.com.lucaskano.KanoBanking.controller

import br.com.lucaskano.KanoBanking.domain.entities.Customer
import br.com.lucaskano.KanoBanking.dto.CustomerDTO
import br.com.lucaskano.KanoBanking.repository.CustomerRepository
import br.com.lucaskano.KanoBanking.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1")
class CustomerController(
        @Autowired private val customerService: CustomerService
) {

    @GetMapping("/customers/{id}")
    fun findCustomerById(@PathVariable id: Int) = ResponseEntity.ok(customerService.findById(id))

    @GetMapping("/customers")
    fun findAllCustomers() = ResponseEntity.ok(customerService.listAll())

    @PostMapping(
            "/customers",
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun insertCustomer(@RequestBody customer: Customer) {
        customerService.save(customer)
        ResponseEntity.ok()
    }

    @PutMapping(
            "/customers/{id}",
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun updateCustomerById(@PathVariable id: Int, @RequestBody customer: Customer) =
            ResponseEntity.ok(customerService.updateById(id, customer))

    @DeleteMapping(
            "/customers/{id}")
    fun deleteCustomerById(@PathVariable id: Int) = ResponseEntity.ok(customerService.deleteById(id))
}