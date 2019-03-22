package com.example.demo;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:test-configuration.properties"})
public class DemoApplicationTests {
  @Autowired private TestRestTemplate restTemplate;

  @Test
  public void contextLoads() throws JSONException {
    String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
    System.out.println("cevap :" + response);
    JSONAssert.assertEquals("[{id:1001,name:item1}]", response, false);
    //  JSONAssert.assertEquals("[{id:1001},{id:1002}]", response, false);
  }
}
