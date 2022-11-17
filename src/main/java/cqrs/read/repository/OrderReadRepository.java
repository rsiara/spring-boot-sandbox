package cqrs.read.repository;

import cqrs.read.model.order.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderReadRepository {

  private final HashMap<Integer, Order> orderStore = new HashMap<>();

  public Order findById(String orderId) {
    return orderStore.get(orderId);
  }

  public List<Order> findAll(){
    return new ArrayList<>(orderStore.values());
  }

  public void create(Order order){
      orderStore.put(
          orderStore.size(),
          order
      );
  }

  public void update(Order order) {
      orderStore.replace(order.getOrderId(), order);
  }
}
