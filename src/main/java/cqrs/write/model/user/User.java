package cqrs.write.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
public class User {

  private String userId;
  private String firstName;
  private String lastName;
  private String email;

  public User(String userId, String firstName, String lastName, String email) {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
