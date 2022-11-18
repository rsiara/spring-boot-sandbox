package cqrs.read.event.handler;

import cqrs.read.event.Event;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Log4j2
@Component
public class EventHandler {

  @JmsListener(destination = "local.event.bus")
  public void onMessage(Event event) {

    log.info("Message received : " + event);
  }
}