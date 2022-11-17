package cqrs.read.model.orderdetail;

import cqrs.read.model.order.Order;
import cqrs.read.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailed {

  private Integer orderId;
  private Order orderRead;
  private User userRead;
}
