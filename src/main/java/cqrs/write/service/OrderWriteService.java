package cqrs.write.service;

import cqrs.model.order.OrderWrite;
import cqrs.write.repository.OrderWriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderWriteService {

  private OrderWriteRepository orderWriteRepository;

  @Autowired
  public OrderWriteService(OrderWriteRepository orderWriteRepository) {
    this.orderWriteRepository = orderWriteRepository;
  }

  public void create(OrderWrite orderWrite){
    orderWriteRepository.save(orderWrite);
  }
}
