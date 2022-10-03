package cqrs.write.repository;

import cqrs.model.user.UserWrite;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserWriteRepository {

  private final HashMap<String, UserWrite> userHashMap = new HashMap<>();

  public void create(String userId, UserWrite userWrite) {

    userHashMap.put(userId, userWrite);
  }

  public UserWrite getUser(String userId) {

    return userHashMap.get(userId);
  }
}
