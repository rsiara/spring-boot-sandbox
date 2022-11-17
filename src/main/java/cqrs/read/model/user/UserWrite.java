package cqrs.read.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class UserWrite {

  private String userid;
  private String firstName;
  private String lastName;
  private Set<Contact> contacts;
  private Set<Address> addresses;

  public UserWrite(String userid, String firstName, String lastName) {
    this.userid = userid;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
