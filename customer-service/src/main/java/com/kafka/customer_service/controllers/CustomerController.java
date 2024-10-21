package com.kafka.customer_service.controllers;

import com.kafka.customer_service.models.entities.Customer;
import com.kafka.customer_service.repositories.CustomerRepository;
import com.kafka.customer_service.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer){
        return this.customerService.create(customer);
    }

    @GetMapping
    public List<Customer> getAll(){
        return this.customerRepository.findAll();
    }
}
