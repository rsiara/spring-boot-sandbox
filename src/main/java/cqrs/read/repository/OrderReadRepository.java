package cqrs.read.repository;

import cqrs.model.order.OrderRead;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderReadRepository {

  private final HashMap<String, OrderRead> orderReadStore = new HashMap<>();

  public OrderRead findById(String orderId) {
    return orderReadStore.get(orderId);
  }

  public List<OrderRead> findAll(){
    return orderReadStore.values().stream().collect(Collectors.toList());
  }
}
