
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
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080"  + "/calculateFrequency?inputString=aaaaabcccc", String.class);
        assertEquals("\"a\":5, \"c\":4, \"b\":1", response.getBody());
    }

    @Test
    public void testCalculateFrequency2() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080"  + "/calculateFrequency?inputString=FFFFжжжэ1", String.class);
        assertEquals("\"F\":4, \"ж\":3, \"1\":1, \"э\":1", response.getBody());
    }
}
