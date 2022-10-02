package cqrs.write.command;

import lombok.Data;

@Data
public class CreateUserCommandDto {

  private String userId;
  private String firstName;
  private String lastName;
}
