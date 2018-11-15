package io.github.aleksandras_sivkovas.game.dragons.backend;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdsIntegrationTest {

	@LocalServerPort
	private int port;
	
	private TestRestTemplate restTemplate = new TestRestTemplate();
	
	private HttpHeaders httpheaders = new HttpHeaders();
	
	@Test
	public void stage_01_get_100_TaskNotFound() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,httpheaders);
		ResponseEntity<String> response = restTemplate.exchange(
				createURL("/api/v2/2/solve/100"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
	}
	
	private String createURL(String uri) {
		return "http://localhost:" + port + uri;
	}
}
