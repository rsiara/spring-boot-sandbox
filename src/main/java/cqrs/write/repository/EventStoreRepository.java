package cqrs.write.repository;

import cqrs.write.event.Event;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;

@Repository
public class EventStoreRepository {

  LinkedHashMap<String,Event> eventStore = new LinkedHashMap<>();

  public void addEvent(Event event){
    eventStore.put(event.getType(), event);
  }
}
