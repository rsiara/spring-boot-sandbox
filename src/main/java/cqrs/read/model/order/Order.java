package cqrs.read.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Order {

  private Integer orderId;
  private final String userId;
  private final Map<String,String> productIds;
  private final String discountCoupon;

  public Order(Integer orderId, String userId, Map<String,String> productIds, String discountCoupon) {
    this.orderId = orderId;
    this.userId = userId;
    this.productIds = productIds;
    this.discountCoupon = discountCoupon;
  }

  public Order(String userId, Map<String,String> productIds, String discountCoupon) {
    this.userId = userId;
    this.productIds = productIds;
    this.discountCoupon = discountCoupon;
  }
}
