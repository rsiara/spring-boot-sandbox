package cqrs.write.command;

import lombok.Data;

@Data
public class CreateUserCommand {

  private String userId;
  private String firstName;
  private String lastName;
}
