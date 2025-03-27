//junit code
package com.example.backend.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorControllerTest {

@Autowired
private TestRestTemplate restTemplate;

@Test
public void testAdd() {
ResponseEntity<Double> response = restTemplate.getForEntity("/api/calculator/add?a=1&b=3", Double.class);
assertEquals(HttpStatus.OK, response.getStatusCode());
assertEquals(4.0, response.getBody(), 0.001);
}

@Test
public void testAddWithDefaultValues() {
    ResponseEntity<Double> response = restTemplate.getForEntity("/api/calculator/add?a=0&b=0", Double.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(0.0, response.getBody(), 0.001);
}

@Test
public void testSub() {
ResponseEntity<Double> response = restTemplate.getForEntity("/api/calculator/subtract?a=10&b=5", Double.class);
assertEquals(HttpStatus.OK, response.getStatusCode());
assertEquals(5.0, response.getBody(), 0.001);
}

@Test
public void testSubWithDefaultValues() {
    ResponseEntity<Double> response = restTemplate.getForEntity("/api/calculator/subtract?a=0&b=0", Double.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(0.0, response.getBody(), 0.001);
}

@Test
public void testMultiply() {
ResponseEntity<Double> response = restTemplate.getForEntity("/api/calculator/multiply?a=4&b=1", Double.class);
assertEquals(HttpStatus.OK, response.getStatusCode());
assertEquals(4.0, response.getBody(), 0.001);
}

@Test
public void testMultiplyWithDefaultValues() {
    ResponseEntity<Double> response = restTemplate.getForEntity("/api/calculator/multiply?a=1&b=1", Double.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(1.0, response.getBody(), 0.001);
}

@Test
public void testDivide() {
ResponseEntity<Double> response = restTemplate.getForEntity("/api/calculator/divide?a=27&b=9", Double.class);
assertEquals(HttpStatus.OK, response.getStatusCode());
assertEquals(3.0, response.getBody(), 0.001);
}


@Test
public void testDivideWithDefaultValues() {  // Fixed typo from testDivideyWithDefaultValues
    ResponseEntity<Double> response = restTemplate.getForEntity("/api/calculator/divide?a=1&b=1", Double.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(1.0, response.getBody(), 0.001);
}

}