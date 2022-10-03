package cqrs.read.service;

import cqrs.model.user.UserRead;
import cqrs.model.user.UserWrite;
import cqrs.read.repository.UserReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserReadService {

  private UserReadRepository userReadRepository;

  @Autowired
  public UserReadService(UserReadRepository userReadRepository) {
    this.userReadRepository = userReadRepository;
  }

  public UserRead getUser(String userId) {
    return userReadRepository.findById(userId);
  }
}