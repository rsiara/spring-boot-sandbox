package cqrs;

import cqrs.write.aggregate.UserAggregate;
import cqrs.write.command.CreateUserCommand;
import cqrs.write.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class UserController {

  private final UserAggregate userAggregate;

  @Autowired
  public UserController(UserAggregate userAggregate) {
    this.userAggregate = userAggregate;
  }

  @ResponseBody
  @PostMapping("/user")
  public User writeUser(@RequestBody CreateUserCommand userCommand) {

    return userAggregate.handleCreateUserCommand(userCommand);
  }
}
