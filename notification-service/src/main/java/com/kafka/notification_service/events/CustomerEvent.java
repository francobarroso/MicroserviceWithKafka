package com.kafka.notification_service.events;

import java.util.Date;

public record CustomerEvent(String name, String email, Date date, EventType type){
}
