package cqrs.queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.PriorityQueue;

@Configuration
public class EventBusConfiguration {

  @Bean
  public PriorityQueue<Object> getEventBus(){
    return new PriorityQueue<>();
  }
}
