package cqrs.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class OrderWrite {

  private String orderId;
  private final String userId;
  private final String productId;

  public OrderWrite(String userId, String productId) {
    this.userId = userId;
    this.productId = productId;
  }
}
