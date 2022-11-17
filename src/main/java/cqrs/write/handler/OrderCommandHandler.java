package cqrs.write.handler;

import cqrs.projector.OrderProjector;
import cqrs.write.command.order.AddProductCommandDto;
import cqrs.write.command.order.CreateOrderCommandDto;
import cqrs.write.command.order.RemoveProductCommandDto;
import cqrs.write.event.AddProductToOrderEvent;
import cqrs.write.event.CreateOrderEvent;
import cqrs.write.event.RemoveProductFromOrderEvent;
import cqrs.write.repository.EventStoreRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderCommandHandler {

  private final EventStoreRepository eventStoreRepository;
  private final OrderProjector orderProjector;

  @Autowired
  public OrderCommandHandler(EventStoreRepository eventStoreRepository, OrderProjector orderProjector) {
    this.eventStoreRepository = eventStoreRepository;
    this.orderProjector = orderProjector;
  }

  public void handleCreateCommand(CreateOrderCommandDto createOrderCommandDto) {

    CreateOrderEvent createOrderEvent = new CreateOrderEvent(
        createOrderCommandDto.getUserId(),
        createOrderCommandDto.getProductIds(),
        createOrderCommandDto.getDiscountCoupon()
    );

    eventStoreRepository.addEvent(createOrderEvent);
    orderProjector.project(createOrderEvent);
  }

  public void handleAddProductCommand(AddProductCommandDto addProductCommandDto) {

    for (String productToAdd : addProductCommandDto.getProductIds()) {
      AddProductToOrderEvent addProductToOrderEvent = new AddProductToOrderEvent(
          addProductCommandDto.getOrderId(),
          productToAdd
      );
      eventStoreRepository.addEvent(addProductToOrderEvent);
      orderProjector.project(addProductToOrderEvent);
    }
  }

  public void handleRemoveProductCommand(RemoveProductCommandDto removeProductCommandDto) {

    for (String productToRemove : removeProductCommandDto.getProductIds()) {
      RemoveProductFromOrderEvent removeProductFromOrderEvent = new RemoveProductFromOrderEvent(
          removeProductCommandDto.getOrderId(),
          productToRemove
      );
      eventStoreRepository.addEvent(removeProductFromOrderEvent);
      orderProjector.project(removeProductFromOrderEvent);
    }
  }
}
