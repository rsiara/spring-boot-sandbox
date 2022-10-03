package cqrs.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderRead {

  private final String orderId;
  private final String userId;
  private final String productId;
}
