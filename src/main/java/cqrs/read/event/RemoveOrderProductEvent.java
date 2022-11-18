package cqrs.read.event;

import lombok.Data;

import java.util.UUID;

@Data
public class RemoveOrderProductEvent implements Event {

  private String id;
  private String type;
  private String orderId;
  private String productId;

  public RemoveOrderProductEvent(String orderId, String productId) {
    this.id = String.valueOf(UUID.randomUUID());
    this.type = "REMOVE_PRODUCT";
    this.orderId = orderId;
    this.productId = productId;
  }

  @Override
  public String getType() {
    return type;
  }
}
