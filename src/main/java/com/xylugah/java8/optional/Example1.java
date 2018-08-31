package com.xylugah.java8.optional;

import com.xylugah.java8.util.User;
import java.util.Optional;

public class Example1 {

  public static final String DEFAULT = "default";

  public String getUserLogin(User user) {
    if (user != null && user.getLogin() != null) {
      return user.getLogin();
    } else {
      return DEFAULT;
    }
  }

  public String getUserLoginJava8(User user) {
    return Optional.ofNullable(user)
        .map(User::getLogin)
        .orElse(DEFAULT);
  }

}
