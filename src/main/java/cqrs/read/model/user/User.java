package cqrs.read.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
@Data
@AllArgsConstructor
public class User {

  private String userId;
  private String firstName;
  private String lastName;
  private Set<Contact> contacts;
  private Set<Address> addresses;

  public User(String userId, String firstName, String lastName) {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
