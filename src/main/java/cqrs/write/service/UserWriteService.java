package cqrs.write.service;

import cqrs.model.user.UserWrite;
import cqrs.write.repository.UserWriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWriteService {

  private final UserWriteRepository userWriteRepository;

  @Autowired
  public UserWriteService(UserWriteRepository userWriteRepository) {
    this.userWriteRepository = userWriteRepository;
  }

  public void createUser(UserWrite userWrite){
    userWriteRepository.create(userWrite.getUserid(), userWrite);
  }
}
