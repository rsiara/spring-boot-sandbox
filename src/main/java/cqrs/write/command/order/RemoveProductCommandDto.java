package cqrs.write.command.order;

import lombok.Data;

import java.util.List;

@Data
public class RemoveProductCommandDto {

  private final String orderId;
  private final List<String> productIds;
}
