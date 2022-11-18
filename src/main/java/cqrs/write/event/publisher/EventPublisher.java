package cqrs.write.event.publisher;

import cqrs.write.event.Event;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class EventPublisher {

  private final JmsTemplate jmsTemplate;

  @Autowired
  public EventPublisher(JmsTemplate jmsTemplate) {
    this.jmsTemplate = jmsTemplate;
  }

  public void publish(Event event) {
    jmsTemplate.convertAndSend("local.event.bus",event);
    log.info("Event published ", event);
  }
}
