package cqrs.read.handler;

import cqrs.read.model.order.Order;
import cqrs.read.model.order.OrderDetailed;
import cqrs.read.model.order.UserOrderHistory;
import cqrs.read.model.user.User;
import cqrs.read.query.GetOrderQuery;
import cqrs.read.query.GetOrderWithUserDetailQuery;
import cqrs.read.query.GetUserOrderHistoryQuery;
import cqrs.read.service.OrderService;
import cqrs.read.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class OrderQueryHandler {

  @Qualifier("writeUserService")
  private UserService userService;
  private OrderService orderService;

  public Order handleGetOrderQuery(GetOrderQuery getOrderQuery) {

    return orderService.getOrder(getOrderQuery.getOrderId());
  }

  public OrderDetailed handleGetOrderWithUserDetailsQuery(GetOrderWithUserDetailQuery getOrderWithUserDetailQuery) {

    OrderDetailed orderDetail = new OrderDetailed();

    Order order = orderService.getOrder(getOrderWithUserDetailQuery.getOrderId());

    if (order != null) {

      orderDetail.setOrderId(order.getOrderId());
      orderDetail.setOrder(order);
      User user = userService.getUser(order.getUserId());

      if (user != null) {
        orderDetail.setUser(user);
      }
    }
    return orderDetail;
  }

  public UserOrderHistory handleUserOrderHistoryQuery(GetUserOrderHistoryQuery getUserOrderHistoryQuery) {

    UserOrderHistory userOrderHistory = new UserOrderHistory();
    User user = userService.getUser(getUserOrderHistoryQuery.getUserId());

    if (user != null) {

      userOrderHistory.setUser(user);
      Map<Integer, Order> orders = orderService.getOrdersByUserId(user.getUserId());

      if (orders != null) {
        userOrderHistory.setOrders(orders);
      }
    }

    return userOrderHistory;
  }
}
