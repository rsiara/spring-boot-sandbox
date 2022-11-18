package cqrs.write.repository;

import cqrs.write.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {

  private final HashMap<String, User> userStore = new HashMap<>();

  public void create(User user) {

    userStore.put(user.getUserId(), user);
  }

  public User getUser(String userId) {

    return userStore.get(userId);
  }
}
