package cqrs.write.command;

import lombok.Data;

@Data
public class CreateOrderCommandDto {

  private final String userId;
  private final String productId;
}
