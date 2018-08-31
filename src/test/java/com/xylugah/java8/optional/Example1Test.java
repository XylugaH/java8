package com.xylugah.java8.optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.xylugah.java8.util.User;
import org.junit.jupiter.api.Test;

class Example1Test {

  Example1 example = new Example1();

  @Test
  void testWhenUserIsNull() {
    String login1 = example.getUserLogin(null);
    String login2 = example.getUserLoginJava8(null);
    assertEquals(Example1.DEFAULT, login1);
    assertEquals(Example1.DEFAULT, login2);
  }

  @Test
  void testWhenLoginIsNull() {
    User user = new User();
    String login1 = example.getUserLogin(user);
    String login2 = example.getUserLoginJava8(user);
    assertEquals(Example1.DEFAULT, login1);
    assertEquals(Example1.DEFAULT, login2);
  }

  @Test
  void testWhenLoginIsNotNull() {
    String testLogin = "test";
    User user = new User();
    user.setLogin(testLogin);
    String login1 = example.getUserLogin(user);
    String login2 = example.getUserLoginJava8(user);
    assertEquals(testLogin, login1);
    assertEquals(testLogin, login2);
  }
}