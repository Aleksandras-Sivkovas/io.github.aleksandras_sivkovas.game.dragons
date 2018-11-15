package io.github.aleksandras_sivkovas.game.dragons.backend;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AdsIntegrationTest extends DragonsAppIntegrationTest{

	@Test
	public void stage_01_get_100_TaskNotFound() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,getHttpheaders());
		ResponseEntity<String> response = getRestTemplate().exchange(
				createURL("/api/v2/1/solve/100"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
	}
	@Test
	public void stage_02_get_1_TaskDone() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,getHttpheaders());
		ResponseEntity<String> response = getRestTemplate().exchange(
				createURL("/api/v2/3/solve/1"),
				HttpMethod.POST, 
				entity, 
				String.class
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		String expected = "{success:true,lives:10,gold:10,score:20,highScore:50,turn:2}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
}
