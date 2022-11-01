package cqrs.read.aggregate;

import cqrs.model.order.OrderRead;
import cqrs.model.orderdetail.OrderDetailRead;
import cqrs.model.user.UserRead;
import cqrs.model.userorders.UserOrdersRead;
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

  public OrderRead handleGetOrderQuery(GetOrderQuery getOrderQuery){
    return orderReadService.getOrder(getOrderQuery.getOrderId());
  }

  public OrderDetailRead handleGetOrderWithUserDetailsQuery(GetOrderWithUserDetailQuery getOrderWithUserDetailQuery) {

    OrderDetailRead orderDetailRead = new OrderDetailRead();

    OrderRead orderRead = orderReadService.getOrder(getOrderWithUserDetailQuery.getOrderId());

    if (orderRead != null) {
      UserRead userRead = userReadService.getUser(orderRead.getUserId());
      orderDetailRead.setOrderId(orderRead.getOrderId());
      orderDetailRead.setOrderRead(orderRead);
      orderDetailRead.setUserRead(userRead);
    }
    return orderDetailRead;
  }

  public UserOrdersRead handleGetUserOrdersQuery(GetUserOrdersQuery getUserOrdersQuery){

    UserOrdersRead userOrders = new UserOrdersRead();

    UserRead userRead = userReadService.getUser(getUserOrdersQuery.getUserId());

    if(userRead != null){
      userOrders.setUserId(userRead.getUserId());
      List<OrderRead> allUserOrders = orderReadService.getOrdersByUserId(userRead.getUserId());
      userOrders.setOrderReadList(allUserOrders);
    }
    return userOrders;
  }
}