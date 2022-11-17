package cqrs.write.controller;

import cqrs.write.command.CreateUserCommandDto;
import cqrs.read.model.user.UserWrite;
import cqrs.write.service.UserWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class UserWriteController {

  private final UserWriteService userWriteService;

  @Autowired
  public UserWriteController(UserWriteService userWriteService) {
    this.userWriteService = userWriteService;
  }

  @PostMapping("/user")
  public void writeUser(@RequestBody CreateUserCommandDto createUserCommandDto) {

    userWriteService.createUser(
        new UserWrite(
            createUserCommandDto.getUserId(),
            createUserCommandDto.getFirstName(),
            createUserCommandDto.getLastName()));
  }
}
