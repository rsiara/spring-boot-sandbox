package cqrs.read.repository;

import cqrs.read.model.order.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("readOrderRepository")
public class OrderRepository {

  private final HashMap<Integer, Order> orderStore = new HashMap<>();

  public Order findById(String orderId) {
    return orderStore.get(orderId);
  }

  public Map<Integer, Order> findAll(){
    return new HashMap<>(orderStore);
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
