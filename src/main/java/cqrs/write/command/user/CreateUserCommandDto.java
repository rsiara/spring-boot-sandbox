package cqrs.write.command.user;

import lombok.Data;

@Data
public class CreateUserCommandDto {

  private String userId;
  private String firstName;
  private String lastName;
  private String email;
}
