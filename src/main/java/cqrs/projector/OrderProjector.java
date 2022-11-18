package cqrs.projector;

import cqrs.read.model.order.Order;
import cqrs.read.repository.OrderRepository;
import cqrs.write.event.AddOrderProductEvent;
import cqrs.write.event.CreateOrderEvent;
import cqrs.write.event.RemoveOrderProductEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderProjector {

  private OrderRepository orderRepository;

  @Autowired
  public OrderProjector(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public void project(CreateOrderEvent createOrderEvent){

    Order order = new Order(
        createOrderEvent.getUserId(),
        createOrderEvent.getProductIds(),
        createOrderEvent.getDiscountCoupon());

    orderRepository.create(order);
  }

  public void project(AddOrderProductEvent addOrderProductEvent){

    Order order = orderRepository.findById(addOrderProductEvent.getOrderId());

    Map<String,String> updatedProductIds = new HashMap<>();
    updatedProductIds.putAll(order.getProductIds());
    updatedProductIds.put(
        addOrderProductEvent.getProductId(),
        addOrderProductEvent.getProductId());

    Order updatedOrder = new Order(
        order.getUserId(),
        updatedProductIds,
        order.getDiscountCoupon());

    orderRepository.update(updatedOrder);
  }

  public void project(RemoveOrderProductEvent removeOrderProductEvent) {

    Order order = orderRepository.findById(removeOrderProductEvent.getOrderId());

    Map<String, String> updatedProductIds = new HashMap<>();
    updatedProductIds.putAll(order.getProductIds());
    updatedProductIds.remove(removeOrderProductEvent.getProductId());

    Order updatedOrder = new Order(
        order.getUserId(),
        updatedProductIds,
        order.getDiscountCoupon());

    orderRepository.update(updatedOrder);

  }
}
