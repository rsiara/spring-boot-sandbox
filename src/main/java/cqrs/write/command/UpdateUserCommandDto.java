package cqrs.write.command;

import cqrs.model.user.Address;
import cqrs.model.user.Contact;
import lombok.Data;

import java.util.Set;

@Data
public class UpdateUserCommandDto {

  private String userId;
  private Set<Address> addresses;
  private Set<Contact> contacts;
}
