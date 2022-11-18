package cqrs.read.model.order;

import cqrs.read.model.user.User;
import lombok.Data;

import java.util.Map;

@Data
public class UserOrderHistory {

  private User user;
  private Map<Integer, Order> orders;

}
