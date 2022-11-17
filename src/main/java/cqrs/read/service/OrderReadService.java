package cqrs.read.service;

import cqrs.read.model.order.Order;
import cqrs.read.repository.OrderReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderReadService {

  private final OrderReadRepository orderReadRepository;

  @Autowired
  public OrderReadService(OrderReadRepository orderReadRepository) {
    this.orderReadRepository = orderReadRepository;
  }

  public Order getOrder(String orderId) {
    return orderReadRepository.findById(orderId);
  }

  public List<Order> getOrdersByUserId(String userId) {
    List<Order> allOrder = orderReadRepository.findAll();
    return allOrder.stream()
        .filter(orderRead -> orderRead.getUserId().equals(userId))
        .collect(Collectors.toList());
  }
}
