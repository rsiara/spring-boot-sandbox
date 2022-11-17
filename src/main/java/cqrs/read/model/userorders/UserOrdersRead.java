package cqrs.read.model.userorders;

import cqrs.read.model.order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrdersRead {

  private String userId;
  private List<Order> orderReadList;
}
