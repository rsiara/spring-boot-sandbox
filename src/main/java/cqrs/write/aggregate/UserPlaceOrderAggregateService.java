package cqrs.write.aggregate;

import cqrs.model.order.OrderWrite;
import cqrs.model.user.UserRead;
import cqrs.read.service.UserReadService;
import cqrs.write.command.CreateOrderCommandDto;
import cqrs.write.service.OrderWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPlaceOrderAggregateService {

  private final UserReadService userReadService;
  private final OrderWriteService orderWriteService;

  @Autowired
  public UserPlaceOrderAggregateService(UserReadService userReadService, OrderWriteService orderWriteService) {
    this.userReadService = userReadService;
    this.orderWriteService = orderWriteService;
  }

  public void handleUserPlaceOrderCommand(CreateOrderCommandDto createUserCommandDto){

      UserRead userRead = userReadService.getUser(createUserCommandDto.getUserId());

      if(userRead != null){
        orderWriteService.create(new OrderWrite(userRead.getUserId(),createUserCommandDto.getProductId()));
      }
  }

//  public User handleCreateUserCommand(CreateUserCommandDto command) {
//    User user = new User(command.getUserId(), command.getFirstName(), command.getLastName());
//    writeRepository.create(user.getUserid(), user);
//    return user;
//  }
//
//  public User handleUpdateUserCommand(UpdateUserCommand command) {
//    User user = writeRepository.getUser(command.getUserId());
//    user.setAddresses(command.getAddresses());
//    user.setContacts(command.getContacts());
//    writeRepository.create(user.getUserid(), user);
//    return user;
//  }
}
