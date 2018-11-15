package io.github.aleksandras_sivkovas.game.dragons.backend;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.skyscreamer.jsonassert.JSONAssert;
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
public class Get1000PointsIntegrationTest {
	
	@LocalServerPort
	private int port;
	
	private TestRestTemplate restTemplate = new TestRestTemplate();
	
	private HttpHeaders httpheaders = new HttpHeaders();
	
	@Before
	public void setUp() throws Exception{
	}
	
	@Test
	public void stage_01_createGame() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,httpheaders);
		ResponseEntity<String> response = restTemplate.exchange(
				createURL("/api/v2/game/start"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{gameId:\"4\",lives:10,gold:0,level:1,score:0,highScore:1010,turn:1}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	@Test
	public void stage_02_get_1_TaskDone() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,httpheaders);
		ResponseEntity<String> response = restTemplate.exchange(
				createURL("/api/v2/4/solve/1"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{success:true,lives:10,gold:10,score:20,highScore:1010,turn:2}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	@Test
	public void stage_03_get_2_TaskDone() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,httpheaders);
		ResponseEntity<String> response = restTemplate.exchange(
				createURL("/api/v2/4/solve/2"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{success:true,lives:10,gold:30,score:50,highScore:1010,turn:3}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	@Test
	public void stage_04_buy_item_10() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,httpheaders);
		ResponseEntity<String> response = restTemplate.exchange(
				createURL("/api/v2/4/shop/buy/10"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{shoppingSuccess:\"true\",gold:10,lives:10,level:51,turn:4}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void stage_05_get_10_TaskDone() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,httpheaders);
		ResponseEntity<String> response = restTemplate.exchange(
				createURL("/api/v2/4/solve/10"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{success:true,lives:10,gold:210,score:450,highScore:1010,turn:5}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void stage_06_buy_item_11() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,httpheaders);
		ResponseEntity<String> response = restTemplate.exchange(
				createURL("/api/v2/4/shop/buy/11"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{shoppingSuccess:\"true\",gold:202,lives:10,level:81,turn:6}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void stage_07_get_9_TaskDone() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,httpheaders);
		ResponseEntity<String> response = restTemplate.exchange(
				createURL("/api/v2/4/solve/9"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{success:true,lives:10,gold:10202,score:950,highScore:1010,turn:7}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	@Test
	public void stage_08_get_5_TaskDone() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,httpheaders);
		ResponseEntity<String> response = restTemplate.exchange(
				createURL("/api/v2/4/solve/5"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{success:true,lives:10,gold:10242,score:1050,highScore:1050,turn:8}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	private String createURL(String uri) {
		return "http://localhost:" + port + uri;
	}
	
}
