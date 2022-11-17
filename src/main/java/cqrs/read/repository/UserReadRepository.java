package cqrs.read.repository;

import cqrs.read.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserReadRepository {

  private final HashMap<String, User> userReadStore = new HashMap<>();

  public User findById(String userId) {
    return userReadStore.get(userId);
  }
}
