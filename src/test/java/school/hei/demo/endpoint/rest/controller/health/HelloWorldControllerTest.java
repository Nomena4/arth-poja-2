package school.hei.demo.endpoint.rest.controller.health;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloWorldControllerTest {

  @Test
  void hello() {
    assertEquals("Hello World!", new HelloWorldController().hello());
  }
}
