package cqrs.write.event;

import lombok.Data;

import java.util.UUID;

@Data
public class AddOrderProductEvent implements Event {

  private String id;
  private String type;
  private String orderId;
  private String productId;

  public AddOrderProductEvent(String orderId, String productId) {
    this.id = String.valueOf(UUID.randomUUID());
    this.type = "ADD_PRODUCT";
    this.orderId = orderId;
    this.productId = productId;
  }

  @Override
  public String getType() {
    return type;
  }
}
