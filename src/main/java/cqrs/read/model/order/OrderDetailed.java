package cqrs.read.model.order;

import cqrs.read.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailed {

  private Integer orderId;
  private Order order;
  private User user;
}
