package com.kafka.customer_service.events;

import java.util.Date;

public record CustomerEvent(String name, String email, Date date, EventType type){
}
