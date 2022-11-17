package cqrs.projector;

import cqrs.read.model.order.Order;
import cqrs.read.repository.OrderReadRepository;
import cqrs.write.event.AddProductToOrderEvent;
import cqrs.write.event.CreateOrderEvent;
import cqrs.write.event.RemoveProductFromOrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderProjector {

  private OrderReadRepository orderReadRepository;

  @Autowired
  public OrderProjector(OrderReadRepository orderReadRepository) {
    this.orderReadRepository = orderReadRepository;
  }

  public void project(CreateOrderEvent createOrderEvent){

    Order order = new Order(
        createOrderEvent.getUserId(),
        createOrderEvent.getProductIds(),
        createOrderEvent.getDiscountCoupon());

    orderReadRepository.create(order);
  }

  public void project(AddProductToOrderEvent addProductToOrderEvent){

    Order order = orderReadRepository.findById(addProductToOrderEvent.getOrderId());

    Map<String,String> updatedProductIds = new HashMap<>();
    updatedProductIds.putAll(order.getProductIds());
    updatedProductIds.put(
        addProductToOrderEvent.getProductId(),
        addProductToOrderEvent.getProductId());

    Order updatedOrder = new Order(
        order.getUserId(),
        updatedProductIds,
        order.getDiscountCoupon());

    orderReadRepository.update(updatedOrder);
  }

  public void project(RemoveProductFromOrderEvent removeProductFromOrderEvent) {

    Order order = orderReadRepository.findById(removeProductFromOrderEvent.getOrderId());

    Map<String, String> updatedProductIds = new HashMap<>();
    updatedProductIds.putAll(order.getProductIds());
    updatedProductIds.remove(removeProductFromOrderEvent.getProductId());

    Order updatedOrder = new Order(
        order.getUserId(),
        updatedProductIds,
        order.getDiscountCoupon());

    orderReadRepository.update(updatedOrder);

  }
}
