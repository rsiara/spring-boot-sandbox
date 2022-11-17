package cqrs.write.service;

import cqrs.read.model.user.UserWrite;
import cqrs.write.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWriteService {

  private final UserRepository userRepository;

  @Autowired
  public UserWriteService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void createUser(UserWrite userWrite){
    userRepository.create(userWrite.getUserid(), userWrite);
  }
}
