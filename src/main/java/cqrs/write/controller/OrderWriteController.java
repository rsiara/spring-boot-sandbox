package cqrs.write.controller;

import cqrs.write.aggregate.UserPlaceOrderAggregateService;
import cqrs.write.command.CreateOrderCommandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class OrderWriteController {

  private final UserPlaceOrderAggregateService userPlaceOrderAggregateService;

  @Autowired
  public OrderWriteController(UserPlaceOrderAggregateService userPlaceOrderAggregateService) {

    this.userPlaceOrderAggregateService = userPlaceOrderAggregateService;
  }

  @PostMapping(path = "/order")
  public void placeOrder(@RequestBody CreateOrderCommandDto createOrderCommandDto){

    userPlaceOrderAggregateService.handleUserPlaceOrderCommand(createOrderCommandDto);
  }
}
