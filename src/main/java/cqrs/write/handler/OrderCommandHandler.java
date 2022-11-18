package cqrs.write.handler;

import cqrs.projector.OrderProjector;
import cqrs.write.command.order.AddProductCommandDto;
import cqrs.write.command.order.CreateOrderCommandDto;
import cqrs.write.command.order.RemoveProductCommandDto;
import cqrs.write.event.AddOrderProductEvent;
import cqrs.write.event.CreateOrderEvent;
import cqrs.write.event.RemoveOrderProductEvent;
import cqrs.write.event.publisher.EventPublisher;
import cqrs.write.repository.EventStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderCommandHandler {

  private final EventStoreRepository eventStoreRepository;
  private final OrderProjector orderProjector;
  private final EventPublisher eventPublisher;

  @Autowired
  public OrderCommandHandler(EventStoreRepository eventStoreRepository, OrderProjector orderProjector, EventPublisher eventPublisher) {
    this.eventStoreRepository = eventStoreRepository;
    this.orderProjector = orderProjector;
    this.eventPublisher = eventPublisher;
  }

  public void handleCreateCommand(CreateOrderCommandDto createOrderCommandDto) {

    CreateOrderEvent createOrderEvent = new CreateOrderEvent(
        createOrderCommandDto.getUserId(),
        createOrderCommandDto.getProductIds(),
        createOrderCommandDto.getDiscountCoupon()
    );

    eventStoreRepository.addEvent(createOrderEvent);
    orderProjector.project(createOrderEvent);
    eventPublisher.publish(createOrderEvent);
  }

  public void handleAddProductCommand(AddProductCommandDto addProductCommandDto) {

    for (String productToAdd : addProductCommandDto.getProductIds()) {
      AddOrderProductEvent addOrderProductEvent = new AddOrderProductEvent(
          addProductCommandDto.getOrderId(),
          productToAdd
      );
      eventStoreRepository.addEvent(addOrderProductEvent);
      orderProjector.project(addOrderProductEvent);
      eventPublisher.publish(addOrderProductEvent);
    }
  }

  public void handleRemoveProductCommand(RemoveProductCommandDto removeProductCommandDto) {

    for (String productToRemove : removeProductCommandDto.getProductIds()) {
      RemoveOrderProductEvent removeOrderProductEvent = new RemoveOrderProductEvent(
          removeProductCommandDto.getOrderId(),
          productToRemove
      );
      eventStoreRepository.addEvent(removeOrderProductEvent);
      orderProjector.project(removeOrderProductEvent);
      eventPublisher.publish(removeOrderProductEvent);
    }
  }
}
