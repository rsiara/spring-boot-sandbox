package cqrs.write.service;

import cqrs.model.order.OrderWrite;
import cqrs.projection.UserOrderProjection;
import cqrs.write.repository.OrderWriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderWriteService {

  private OrderWriteRepository orderWriteRepository;
  private UserOrderProjection userOrderProjection;

  @Autowired
  public OrderWriteService(OrderWriteRepository orderWriteRepository, UserOrderProjection userOrderProjection) {
    this.orderWriteRepository = orderWriteRepository;
    this.userOrderProjection = userOrderProjection;
  }

  public void create(OrderWrite orderWrite){
    orderWriteRepository.save(orderWrite);
    userOrderProjection.project(orderWrite);
  }
}
