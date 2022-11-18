package cqrs.read.service;

import cqrs.read.model.order.Order;
import cqrs.read.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

  @Qualifier("readOrderRepository")
  private final OrderRepository orderRepository;

  @Autowired
  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public Order getOrder(String orderId) {
    return orderRepository.findById(orderId);
  }

  public Map<Integer, Order> getOrdersByUserId(String userId) {

    Map<Integer, Order> orders = orderRepository.findAll();

    return  orders.values().stream()
        .filter(order -> order.getUserId().equals(userId))
        .collect(Collectors.toMap(Order::getOrderId,order -> order));
  }
}
