package io.github.aleksandras_sivkovas.game.dragons.backend;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class DragonsAppIntegrationTest {
	
	@LocalServerPort
	private int port;
	
	private TestRestTemplate restTemplate = new TestRestTemplate();
	
	private HttpHeaders httpheaders = new HttpHeaders();
	
	protected String createURL(String uri) {
		return "http://localhost:" + port + uri;
	}

	protected TestRestTemplate getRestTemplate() {
		return restTemplate;
	}

	protected void setRestTemplate(TestRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	protected HttpHeaders getHttpheaders() {
		return httpheaders;
	}

	protected void setHttpheaders(HttpHeaders httpheaders) {
		this.httpheaders = httpheaders;
	}
	
}
