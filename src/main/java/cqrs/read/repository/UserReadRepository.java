package cqrs.read.repository;

import cqrs.model.user.UserRead;
import cqrs.model.user.UserWrite;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserReadRepository {

  private final HashMap<String, UserRead> userReadStore = new HashMap<>();

  public UserRead findById(String userId) {
    return userReadStore.get(userId);
  }
}
