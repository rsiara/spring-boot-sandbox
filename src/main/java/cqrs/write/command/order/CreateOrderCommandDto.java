package cqrs.write.command.order;

import lombok.Data;

import java.util.Map;

@Data
public class CreateOrderCommandDto {

  private final String userId;
  private final Map<String, String> productIds;
  private final String discountCoupon;
}
