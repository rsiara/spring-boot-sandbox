package cqrs.write.repository;

import cqrs.model.order.OrderWrite;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class OrderWriteRepository {

  private final HashMap<String, OrderWrite> orderStore = new HashMap<>();

  public OrderWrite save(OrderWrite orderWrite) {
    orderWrite.setOrderId(String.valueOf(orderStore.size() + 1));
    orderStore.put(orderWrite.getOrderId(), orderWrite);
    return orderWrite;
  }
}
