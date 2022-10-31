package cqrs.projector;

import cqrs.model.order.OrderRead;
import cqrs.model.order.OrderWrite;
import cqrs.read.repository.OrderReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserOrderProjector {

  private OrderReadRepository orderReadRepository;

  @Autowired
  public UserOrderProjector(OrderReadRepository orderReadRepository) {
    this.orderReadRepository = orderReadRepository;
  }

  public void project(OrderWrite orderWrite){
    OrderRead orderRead = new OrderRead(orderWrite.getUserId(),orderWrite.getUserId(), orderWrite.getProductId());
    orderReadRepository.addOrder(orderRead.getUserId(), orderRead);
  }
}
