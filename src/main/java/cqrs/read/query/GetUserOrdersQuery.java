package cqrs.read.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserOrdersQuery {

  private final String userId;
}
