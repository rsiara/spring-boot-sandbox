package cqrs.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderWrite {

  private final String userId;
  private final String productId;
}
