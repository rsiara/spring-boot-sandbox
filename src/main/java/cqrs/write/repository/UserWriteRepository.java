package cqrs.write.repository;

import cqrs.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserWriteRepository {

  private final HashMap<String, User> userHashMap = new HashMap<>();

  public void create(String userId, User user) {

    userHashMap.put(userId, user);
  }

  public User getUser(String userId) {

    return userHashMap.get(userId);
  }
}
