package com.kafka.customer_service.services;

import com.kafka.customer_service.events.CustomerEvent;
import com.kafka.customer_service.events.EventType;
import com.kafka.customer_service.models.entities.Customer;
import com.kafka.customer_service.repositories.CustomerRepository;
import com.kafka.customer_service.utils.JsonUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final KafkaTemplate<String,String> kafkaTemplate;

    public CustomerService(CustomerRepository customerRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.customerRepository = customerRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Customer create(Customer customer){
        //TO DO: Send message to order topic
        this.kafkaTemplate.send("customer-topic", JsonUtils.toJson(
                new CustomerEvent(customer.getName(), customer.getEmail(), new Date(), EventType.CREATED)
        ));
        return this.customerRepository.save(customer);
    }
}
