package cqrs.read.aggregate;

import cqrs.read.model.order.Order;
import cqrs.read.model.orderdetail.OrderDetailed;
import cqrs.read.model.user.User;
import cqrs.read.model.userorders.UserOrdersRead;
import cqrs.read.query.GetOrderQuery;
import cqrs.read.query.GetOrderWithUserDetailQuery;
import cqrs.read.query.GetUserOrdersQuery;
import cqrs.read.service.OrderReadService;
import cqrs.read.service.UserReadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OrderProjectionService {

  private UserReadService userReadService;
  private OrderReadService orderReadService;

  public Order handleGetOrderQuery(GetOrderQuery getOrderQuery){
    return orderReadService.getOrder(getOrderQuery.getOrderId());
  }

  public OrderDetailed handleGetOrderWithUserDetailsQuery(GetOrderWithUserDetailQuery getOrderWithUserDetailQuery) {

    OrderDetailed orderDetailRead = new OrderDetailed();

    Order orderRead = orderReadService.getOrder(getOrderWithUserDetailQuery.getOrderId());

    if (orderRead != null) {
      User userRead = userReadService.getUser(orderRead.getUserId());
      orderDetailRead.setOrderId(orderRead.getOrderId());
      orderDetailRead.setOrderRead(orderRead);
      orderDetailRead.setUserRead(userRead);
    }
    return orderDetailRead;
  }

  public UserOrdersRead handleGetUserOrdersQuery(GetUserOrdersQuery getUserOrdersQuery){

    UserOrdersRead userOrders = new UserOrdersRead();

    User userRead = userReadService.getUser(getUserOrdersQuery.getUserId());

    if(userRead != null){
      userOrders.setUserId(userRead.getUserId());
      List<Order> allUserOrders = orderReadService.getOrdersByUserId(userRead.getUserId());
      userOrders.setOrderReadList(allUserOrders);
    }
    return userOrders;
  }
}
