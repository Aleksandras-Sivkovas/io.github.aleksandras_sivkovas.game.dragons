package io.github.aleksandras_sivkovas.game.dragons.backend;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Get1000PointsIntegrationTest extends DragonsAppIntegrationTest{
	
	@Test
	public void get_1000_points() throws Exception{
		createGame();
		get_1_TaskDone();
		get_2_TaskDone();
		buyItem_10();
		get_10_TaskDone();
		buyItem_11();
		get_9_TaskDone();
		get_5_TaskDone();
		
	}
	
	public void createGame() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,getHttpheaders());
		ResponseEntity<String> response = getRestTemplate().exchange(
				createURL("/api/v2/game/start"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{gameId:\"4\",lives:10,gold:0,level:1,score:0,highScore:50,turn:1}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	public void get_1_TaskDone() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,getHttpheaders());
		ResponseEntity<String> response = getRestTemplate().exchange(
				createURL("/api/v2/4/solve/1"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{success:true,lives:10,gold:10,score:20,highScore:50,turn:2}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	public void get_2_TaskDone() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,getHttpheaders());
		ResponseEntity<String> response = getRestTemplate().exchange(
				createURL("/api/v2/4/solve/2"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{success:true,lives:10,gold:30,score:50,highScore:50,turn:3}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	public void buyItem_10() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,getHttpheaders());
		ResponseEntity<String> response = getRestTemplate().exchange(
				createURL("/api/v2/4/shop/buy/10"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{shoppingSuccess:\"true\",gold:10,lives:10,level:51,turn:4}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	public void get_10_TaskDone() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,getHttpheaders());
		ResponseEntity<String> response = getRestTemplate().exchange(
				createURL("/api/v2/4/solve/10"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{success:true,lives:10,gold:210,score:450,highScore:450,turn:5}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	public void buyItem_11() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,getHttpheaders());
		ResponseEntity<String> response = getRestTemplate().exchange(
				createURL("/api/v2/4/shop/buy/11"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{shoppingSuccess:\"true\",gold:202,lives:10,level:81,turn:6}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	public void get_9_TaskDone() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,getHttpheaders());
		ResponseEntity<String> response = getRestTemplate().exchange(
				createURL("/api/v2/4/solve/9"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{success:true,lives:10,gold:10202,score:950,highScore:950,turn:7}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	public void get_5_TaskDone() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,getHttpheaders());
		ResponseEntity<String> response = getRestTemplate().exchange(
				createURL("/api/v2/4/solve/5"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{success:true,lives:10,gold:10242,score:1050,highScore:1050,turn:8}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
}
