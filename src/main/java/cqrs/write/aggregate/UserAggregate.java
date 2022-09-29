package cqrs.write.aggregate;

import cqrs.write.command.CreateUserCommand;
import cqrs.write.command.UpdateUserCommand;
import cqrs.write.model.User;
import cqrs.write.repository.UserWriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAggregate {

  private final UserWriteRepository writeRepository;

  @Autowired
  public UserAggregate(UserWriteRepository repository) {
    this.writeRepository = repository;
  }

  public User handleCreateUserCommand(CreateUserCommand command) {
    User user = new User(command.getUserId(), command.getFirstName(), command.getLastName());
    writeRepository.create(user.getUserid(), user);
    return user;
  }

  public User handleUpdateUserCommand(UpdateUserCommand command) {
    User user = writeRepository.getUser(command.getUserId());
    user.setAddresses(command.getAddresses());
    user.setContacts(command.getContacts());
    writeRepository.create(user.getUserid(), user);
    return user;
  }
}
