package Patterns;

import Domain.Events;

public class EventsFactory {
    public static Events createEvent(String eventType, String name) {
        switch (eventType) {
            case "Book":
                return new BookEvent(name);
            case "Other":
                return new OtherEvent(name);
            // Add more cases for different event types as needed
            default:
                throw new IllegalArgumentException("Unsupported event type: " + eventType);
        }
    }
}

