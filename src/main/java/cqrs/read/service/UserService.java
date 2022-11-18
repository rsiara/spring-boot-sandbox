package cqrs.read.service;

import cqrs.read.model.user.User;
import cqrs.read.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("readUserService")
public class UserService {

  @Qualifier("readUserRepository")
  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getUser(String userId) {
    return userRepository.findById(userId);
  }
}
