package cqrs.write.event;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class CreateOrderEvent implements Event{

  private String id;
  private String type;
  private String userId;
  private Map<String, String> productIds;
  private String discountCoupon;

  public CreateOrderEvent(String userId, Map<String, String> productIds, String discountCoupon) {
    this.id = String.valueOf(UUID.randomUUID());
    this.type = "CREATE";
    this.userId = userId;
    this.productIds = productIds;
    this.discountCoupon = discountCoupon;
  }
}
