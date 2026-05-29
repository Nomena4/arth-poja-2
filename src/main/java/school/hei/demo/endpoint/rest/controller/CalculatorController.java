package school.hei.demo.endpoint.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CalculatorController {

  @GetMapping("/add")
  public double add(@RequestParam(name = "a") double a, @RequestParam(name = "b") double b) {
    return a + b;
  }

  @GetMapping("/subtract")
  public double subtract(@RequestParam(name = "a") double a, @RequestParam(name = "b") double b) {
    return a - b;
  }

  @GetMapping("/multiply")
  public double multiply(@RequestParam(name = "a") double a, @RequestParam(name = "b") double b) {
    return a * b;
  }

  @GetMapping("/divide")
  public double divide(@RequestParam(name = "a") double a, @RequestParam(name = "b") double b) {
    if (b == 0) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Division by zero is not allowed");
    }
    return a / b;
  }
}
