package school.hei.demo.endpoint.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import school.hei.demo.conf.FacadeIT;

@AutoConfigureMockMvc
class CalculatorControllerIT extends FacadeIT {

  @Autowired private MockMvc mockMvc;

  @Test
  void add() throws Exception {
    mockMvc
        .perform(get("/add").param("a", "10").param("b", "5"))
        .andExpect(status().isOk())
        .andExpect(content().string("15.0"));
  }

  @Test
  void subtract() throws Exception {
    mockMvc
        .perform(get("/subtract").param("a", "10").param("b", "5"))
        .andExpect(status().isOk())
        .andExpect(content().string("5.0"));
  }

  @Test
  void multiply() throws Exception {
    mockMvc
        .perform(get("/multiply").param("a", "10").param("b", "5"))
        .andExpect(status().isOk())
        .andExpect(content().string("50.0"));
  }

  @Test
  void divide() throws Exception {
    mockMvc
        .perform(get("/divide").param("a", "10").param("b", "5"))
        .andExpect(status().isOk())
        .andExpect(content().string("2.0"));
  }

  @Test
  void divideByZero() throws Exception {
    mockMvc
        .perform(get("/divide").param("a", "10").param("b", "0"))
        .andExpect(status().isBadRequest());
  }
}
