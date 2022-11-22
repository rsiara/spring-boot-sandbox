package cqrs.read.event;

import cqrs.write.event.Event;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
public class CreateOrderEvent implements Event {

  public static final String TYPE = "CREATE";

  private String id;
  private String type;
  private String userId;
  private Map<String, String> productIds;
  private String discountCoupon;

  public CreateOrderEvent(String userId, Map<String, String> productIds, String discountCoupon) {
    this.id = String.valueOf(UUID.randomUUID());
    this.type = TYPE;
    this.userId = userId;
    this.productIds = productIds;
    this.discountCoupon = discountCoupon;
  }
}
