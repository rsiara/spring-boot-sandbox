package cqrs.read.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserOrderHistoryQuery {

  private final String userId;
}
