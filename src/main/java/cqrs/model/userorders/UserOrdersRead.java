package cqrs.model.userorders;

import cqrs.model.order.OrderRead;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrdersRead {

  private String userId;
  private List<OrderRead> orderReadList;
}
