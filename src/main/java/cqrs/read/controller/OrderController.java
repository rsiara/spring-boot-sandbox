package cqrs.read.controller;

import cqrs.read.model.order.Order;
import cqrs.read.model.order.OrderDetailed;
import cqrs.read.model.order.UserOrderHistory;
import cqrs.read.handler.OrderQueryHandler;
import cqrs.read.query.GetOrderQuery;
import cqrs.read.query.GetOrderWithUserDetailQuery;
import cqrs.read.query.GetUserOrderHistoryQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

  private OrderQueryHandler orderQueryHandler;

  @Autowired
  public OrderController(OrderQueryHandler orderQueryHandler) {
    this.orderQueryHandler = orderQueryHandler;
  }

  @GetMapping(path = "/order")
  public Order getOrder(GetOrderQuery getOrderQuery){
    return orderQueryHandler.handleGetOrderQuery(getOrderQuery);
  }

  @GetMapping(path = "/order/detail")
  public OrderDetailed getUserOrderDetails(GetOrderWithUserDetailQuery getOrderWithUserDetailQuery){
    return orderQueryHandler.handleGetOrderWithUserDetailsQuery(getOrderWithUserDetailQuery);
  }

  @GetMapping(path = "/order/user")
  public UserOrderHistory getUserOrders(GetUserOrderHistoryQuery getUserOrderHistoryQuery){
    return orderQueryHandler.handleUserOrderHistoryQuery(getUserOrderHistoryQuery);
  }
}
