package cqrs.write.event.publisher;

import cqrs.write.event.Event;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;

@Log4j2
@Component
public class EventPublisher {

  private final JmsTemplate jmsTemplate;
  private final Queue queue;

  @Autowired
  public EventPublisher(JmsTemplate jmsTemplate, Queue queue) {
    this.jmsTemplate = jmsTemplate;
    this.queue = queue;
  }

  public void publish(Event event) {
    jmsTemplate.convertAndSend("local.event.bus", event, message -> {
          message.setStringProperty("type", event.getType());
          return message;
        });
    log.info("Event published ", event);
  }
}
