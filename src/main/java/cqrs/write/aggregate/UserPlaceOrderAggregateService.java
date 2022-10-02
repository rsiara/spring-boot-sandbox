package cqrs.write.aggregate;

import cqrs.write.command.CreateOrderCommandDto;
import cqrs.write.command.CreateUserCommandDto;
import cqrs.write.command.UpdateUserCommand;
import cqrs.model.user.User;
import cqrs.write.repository.UserWriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPlaceOrderAggregateService {

  private final UserWriteRepository writeRepository;

  @Autowired
  public UserPlaceOrderAggregateService(UserWriteRepository repository) {
    this.writeRepository = repository;
  }

  public void handleUserPlaceOrderCommand(CreateOrderCommandDto createUserCommandDto){


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
