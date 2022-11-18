package cqrs.write.service;

import cqrs.write.model.user.User;
import cqrs.write.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("writeUserService")
public class UserService {

  @Qualifier("writeUserRepository")
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void createUser(User user) {
    userRepository.create(user);
  }
}
