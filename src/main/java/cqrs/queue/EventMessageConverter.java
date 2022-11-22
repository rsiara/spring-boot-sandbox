package cqrs.queue;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import cqrs.read.event.CreateOrderEvent;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConversionException;

import javax.jms.JMSException;
import javax.jms.Message;

public class EventMessageConverter extends MappingJackson2MessageConverter {

//  @Override
//  protected JavaType getJavaTypeForMessage(Message message) throws JMSException {
//    if(message.getStringProperty("type")=="CREATE") {
//      return TypeFactory.defaultInstance().constructType(CreateOrderEvent.class);
//    }
//    return TypeFactory.unknownType();
//  }
}
