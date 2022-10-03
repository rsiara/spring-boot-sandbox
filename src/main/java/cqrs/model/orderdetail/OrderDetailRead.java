package cqrs.model.orderdetail;

import cqrs.model.order.OrderRead;
import cqrs.model.user.UserRead;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailRead {

  private String orderId;
  private OrderRead orderRead;
  private UserRead userRead;
}
