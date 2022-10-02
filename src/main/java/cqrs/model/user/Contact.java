package cqrs.model.user;

import lombok.Data;

@Data
public class Contact {

  private String type;
  private String detail;
}
