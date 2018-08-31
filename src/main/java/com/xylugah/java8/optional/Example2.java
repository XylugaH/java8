package com.xylugah.java8.optional;

import com.xylugah.java8.util.User;
import com.xylugah.java8.util.UserRepository;
import java.util.Optional;

public class Example2 {

  private final UserRepository repository;

  public Example2(UserRepository repository) {
    this.repository = repository;
  }

  public User getUserOrThrowException(Long id) {
    User user = repository.findById(id);
    if (user != null) {
      return user;
    } else {
      throw new RuntimeException();
    }
  }

  public User getUserOrThrowExceptionJava8(Long id) {
    User user = repository.findById(id);
    return Optional.ofNullable(user)
        .orElseThrow(RuntimeException::new);
  }
}
