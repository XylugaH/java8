package com.xylugah.java8.optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.xylugah.java8.util.User;
import com.xylugah.java8.util.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Example2Test {

  private Example2 example;

  private UserRepository repository;

  @BeforeEach
  void setUp() {
    repository = mock(UserRepository.class);
    example = new Example2(repository);
  }

  @Test
  void testWhenUserNotFound() {
    Long userId = 1L;
    when(repository.findById(userId)).thenReturn(null);
    assertThrows(RuntimeException.class, () -> example.getUserOrThrowException(userId));
    assertThrows(RuntimeException.class, () -> example.getUserOrThrowExceptionJava8(userId));
  }

  @Test
  void testWhenUserIsFound() {
    Long userId = 1L;
    User expectedUser = new User();
    when(repository.findById(userId)).thenReturn(expectedUser);
    assertEquals(expectedUser, example.getUserOrThrowException(userId));
    assertEquals(expectedUser, example.getUserOrThrowExceptionJava8(userId));
  }
}
