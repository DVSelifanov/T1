
package com.example.T1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FrequencyControllerTest {



    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testCalculateFrequency() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080"  + "/calculate?inputString=aaaaabcccc", String.class);
        assertEquals("\"a\":5, \"c\":4, \"b\":1", response.getBody());
    }

    @Test
    public void testCalculateFrequency2() {

    }
}
