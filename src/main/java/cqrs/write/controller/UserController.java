package cqrs.write.controller;

import cqrs.write.command.user.CreateUserCommandDto;
import cqrs.write.model.user.User;
import cqrs.write.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class UserController {

  @Qualifier("writeUserService")
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/user/create")
  public void writeUser(@RequestBody CreateUserCommandDto createUserCommandDto) {

    userService.createUser(
        new User(
            createUserCommandDto.getUserId(),
            createUserCommandDto.getFirstName(),
            createUserCommandDto.getLastName(),
            createUserCommandDto.getEmail())
    );
  }
}
