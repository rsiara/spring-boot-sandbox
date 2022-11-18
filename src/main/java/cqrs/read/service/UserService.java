package cqrs.read.service;

import cqrs.read.model.user.User;
import cqrs.read.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getUser(String userId) {
    return userRepository.findById(userId);
  }
}
