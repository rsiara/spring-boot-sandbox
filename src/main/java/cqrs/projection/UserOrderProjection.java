package cqrs.projection;

import cqrs.model.order.OrderRead;
import cqrs.model.order.OrderWrite;
import cqrs.read.repository.OrderReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserOrderProjection {

  private OrderReadRepository orderReadRepository;

  @Autowired
  public UserOrderProjection(OrderReadRepository orderReadRepository) {
    this.orderReadRepository = orderReadRepository;
  }

  public void project(OrderWrite orderWrite){
    OrderRead orderRead = new OrderRead(orderWrite.getUserId(),orderWrite.getUserId(), orderWrite.getProductId());
    orderReadRepository.addOrder(orderRead.getUserId(), orderRead);
  }
}
