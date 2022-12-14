package cqrs.queue;

import cqrs.read.event.CreateOrderEvent;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Queue;
import java.util.HashMap;

@EnableJms
@Configuration
public class ActiveMQConfiguration {

  @Bean
  public Queue queue() {
    return new ActiveMQQueue("local.event.bus");
  }

//  @Bean
//  public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
//                                                  DefaultJmsListenerContainerFactoryConfigurer configurer) {
//    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//    // This provides all boot's default to this factory, including the message converter
//    configurer.configure(factory, connectionFactory);
//    // You could still override some of Boot's default if necessary.
//    return factory;
//  }
//
//  @Bean // Serialize message content to json using TextMessage
//  public MessageConverter jacksonJmsMessageConverter() {
//    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//    converter.setTargetType(MessageType.TEXT);
//    converter.setTypeIdPropertyName("_type");
//    return converter;
//  }
@Bean // Serialize message content to json using TextMessage
public MessageConverter messageConverter() {
  EventMessageConverter converter = new EventMessageConverter();
  converter.setTargetType(MessageType.TEXT);
  converter.setTypeIdPropertyName("type");
  converter.setTypeIdMappings(new HashMap<String,Class<?>>(){{
    put(CreateOrderEvent.TYPE, CreateOrderEvent.class);
  }});
  return converter;
}
}