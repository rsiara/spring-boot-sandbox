package cqrs.read.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetOrderQuery {

  private final String orderId;
}
