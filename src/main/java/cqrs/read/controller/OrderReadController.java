package cqrs.read.controller;

import cqrs.read.model.order.Order;
import cqrs.read.model.orderdetail.OrderDetailed;
import cqrs.read.model.userorders.UserOrdersRead;
import cqrs.read.aggregate.OrderProjectionService;
import cqrs.read.query.GetOrderQuery;
import cqrs.read.query.GetOrderWithUserDetailQuery;
import cqrs.read.query.GetUserOrdersQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderReadController {

  private OrderProjectionService userReadOrderAggregateService;

  @Autowired
  public OrderReadController(OrderProjectionService userReadOrderAggregateService) {
    this.userReadOrderAggregateService = userReadOrderAggregateService;
  }

  @GetMapping(path = "order")
  public Order getOrder(GetOrderQuery getOrderQuery){
    return userReadOrderAggregateService.handleGetOrderQuery(getOrderQuery);
  }

  @GetMapping(path = "order/user/detail")
  public OrderDetailed getUserOrderDetails(GetOrderWithUserDetailQuery getOrderWithUserDetailQuery){
    return userReadOrderAggregateService.handleGetOrderWithUserDetailsQuery(getOrderWithUserDetailQuery);
  }

  @GetMapping(path = "order/user")
  public UserOrdersRead getUserOrders(GetUserOrdersQuery getUserOrdersQuery){
    return userReadOrderAggregateService.handleGetUserOrdersQuery(getUserOrdersQuery);
  }
}
