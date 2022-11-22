package cqrs.read.event.handler;

import com.example.demo.DemoApplication;
import cqrs.write.event.CreateOrderEvent;
import cqrs.write.event.Event;
import cqrs.write.event.publisher.EventPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoApplication.class)
class EventHandlerTest {

  @Autowired
  EventPublisher eventPublisher;
  @Autowired
  EventHandler eventHandler;

  @Test
  void onMessage() {

    Event createOrderEvent = new CreateOrderEvent(
        "fakeId",
        Collections.singletonMap("p111222333","p111222333"),
        "black-week"
    );

    eventPublisher.publish(createOrderEvent);
  }
}