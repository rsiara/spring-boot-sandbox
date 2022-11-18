package cqrs.read.repository;

import cqrs.read.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {

  private final HashMap<String, User> userStore = new HashMap<>();

  public User findById(String userId) {
    return userStore.get(userId);
  }
}
