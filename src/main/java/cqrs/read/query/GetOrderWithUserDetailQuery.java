package cqrs.read.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetOrderWithUserDetailQuery {

  private final String orderId;
}
