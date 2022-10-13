package cqrs.read.repository;

import cqrs.model.order.OrderRead;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderReadRepository {

  private final HashMap<String, List<OrderRead>> userToOrdersReadStore = new HashMap<>();

  public OrderRead findById(String orderId) {
    return userToOrdersReadStore.values().stream().flatMap(Collection::stream)
        .filter(orderRead -> orderRead.getOrderId().equals(orderId))
        .findFirst().orElse(null);
  }

  public List<OrderRead> findAll(){
    return userToOrdersReadStore.values().stream().flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  public void addOrder(String userId, OrderRead orderRead){
      List<OrderRead> currentUserOrderList = userToOrdersReadStore
          .getOrDefault(userId, Collections.emptyList());

      currentUserOrderList.add(orderRead);
      userToOrdersReadStore.put(userId, currentUserOrderList);
  }
}
