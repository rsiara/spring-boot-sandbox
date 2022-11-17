package cqrs.write.command.order;

import lombok.Data;

import java.util.List;

@Data
public class AddProductCommandDto {

  private final String orderId;
  private final List<String> productIds;
}
