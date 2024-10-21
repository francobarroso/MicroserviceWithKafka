package com.kafka.notification_service.listeners;

import com.kafka.notification_service.events.CustomerEvent;
import com.kafka.notification_service.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerEventListener {
    @KafkaListener(topics = "customer-topic")
    public void handleCustomerNotifications(String message){
        var customerEvent = JsonUtils.fromJson(message, CustomerEvent.class);
        log.info("Customer {} event received : {} with {} items : ", customerEvent.date(), customerEvent.type(), customerEvent.name(), customerEvent.email());
    }
}
