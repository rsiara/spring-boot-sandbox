package cqrs.write.repository;

import cqrs.model.order.OrderWrite;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class OrderWriteRepository {

  private final HashMap<String, OrderWrite> orderStore = new HashMap<>();

  public void save(OrderWrite orderWrite) {
    orderStore.put(String.valueOf(orderStore.size() + 1), orderWrite);
  }
}
