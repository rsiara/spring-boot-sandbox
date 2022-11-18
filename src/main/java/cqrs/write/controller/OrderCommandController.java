package cqrs.write.controller;

import cqrs.write.command.order.AddProductCommandDto;
import cqrs.write.command.order.RemoveProductCommandDto;
import cqrs.write.handler.OrderCommandHandler;
import cqrs.write.command.order.CreateOrderCommandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/order")
public class OrderCommandController {

  private final OrderCommandHandler orderCommandHandler;

  @Autowired
  public OrderCommandController(OrderCommandHandler orderCommandHandler) {

    this.orderCommandHandler = orderCommandHandler;
  }

  @PostMapping(path = "/create")
  public void placeOrder(@RequestBody CreateOrderCommandDto createOrderCommandDto){

    orderCommandHandler.handleCreateCommand(createOrderCommandDto);
  }

  @PostMapping(path = "/product/add")
  public void addProduct(@RequestBody AddProductCommandDto addProductCommandDto){

    orderCommandHandler.handleAddProductCommand(addProductCommandDto);
  }

  @PostMapping(path = "/product/remove")
  public void removeProduct(@RequestBody RemoveProductCommandDto removeProductCommandDto){

    orderCommandHandler.handleRemoveProductCommand(removeProductCommandDto);
  }
}
