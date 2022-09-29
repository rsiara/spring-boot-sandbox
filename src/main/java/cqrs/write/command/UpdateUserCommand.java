package cqrs.write.command;

import cqrs.write.model.Address;
import cqrs.write.model.Contact;
import lombok.Data;

import java.util.Set;

@Data
public class UpdateUserCommand {

  private String userId;
  private Set<Address> addresses;
  private Set<Contact> contacts;
}
