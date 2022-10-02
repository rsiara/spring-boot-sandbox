package cqrs.write.repository;

import cqrs.model.order.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class OrderWriteRepository {

  private final HashMap<String, Order> userToOrderMap = new HashMap<>();

  public void createOrder(String userId, Order order) {
    userToOrderMap.put(userId, order);
  }
}
