package cqrs.write.service;

import cqrs.model.order.OrderWrite;
import cqrs.projector.UserOrderProjector;
import cqrs.write.repository.OrderWriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderWriteService {

  private OrderWriteRepository orderWriteRepository;
  private UserOrderProjector userOrderProjector;

  @Autowired
  public OrderWriteService(OrderWriteRepository orderWriteRepository, UserOrderProjector userOrderProjector) {
    this.orderWriteRepository = orderWriteRepository;
    this.userOrderProjector = userOrderProjector;
  }

  public void create(OrderWrite orderWrite){
    orderWriteRepository.save(orderWrite);
    userOrderProjector.project(orderWrite);
  }
}
