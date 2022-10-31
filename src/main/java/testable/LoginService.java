package testable;

import lombok.AllArgsConstructor;
import testable.model.User;

import java.util.*;

@AllArgsConstructor
public class LoginService {

  Map<String, User> userMap = Collections.singletonMap("bob", new User("bob", "123456"));

  public boolean logIn(String username, String password) {

    return userMap.containsKey(username) && userMap.get(username).getPassword().equals(password);
  }

  public boolean logIn(User user) {

    return userMap.containsKey(user.getUsername()) && userMap.get(user.getUsername()).getPassword().equals(user.getPassword());
  }
}
