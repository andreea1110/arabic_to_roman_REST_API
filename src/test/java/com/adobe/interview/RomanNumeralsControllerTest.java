package com.adobe.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest(
    classes = InterviewApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RomanNumeralsControllerTest {

    @LocalServerPort //autowire random port into the port class private variable
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

    private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

    // testing OK status code (200 OK if range inside set boundaries)
    @Test
    public void testConvertNumbers_insideBoundaries__200IsReceived() throws ResponseStatusException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/arabicToRoman?min=1&max=100"),
                                                                HttpMethod.GET, 
                                                                entity,
                                                                String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    // testing error status code (400 Bad Request if range outside set boundaries)
    @Test
    public void testConvertNumbers_outsideBoundaries__400IsReceived() throws ResponseStatusException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/arabicToRoman?min=1&max=105"),
                                                                HttpMethod.GET, 
                                                                entity,
                                                                String.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }


    // testing JSON payload
	@Test
    public void testConvertNumbers_withinBoundaries_retrievedJSONisCorrect() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/arabicToRoman?min=1&max=10"),
                                                                HttpMethod.GET, 
                                                                entity,
                                                                String.class);

		String expected = "{\"id\":2,\"content\":[\"I\",\"II\",\"III\",\"IV\",\"V\",\"VI\",\"VII\",\"VIII\",\"IX\",\"X\"]}";

		assertEquals(expected, response.getBody());
	}
}   