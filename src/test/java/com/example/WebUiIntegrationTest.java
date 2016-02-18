package com.example;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WebUiIntegrationTest {
	private static String HELLO_URL = "http://localhost:8080/hello";
	
	@Test
	public void testHello() throws Exception {
		Client client = Client.create();
		WebResource webResource = client.resource(HELLO_URL);
		String response = webResource.get(String.class);
		
		assertThat(response, is("Hello, World!"));
	}

	@Test
	public void testHelloUser() throws Exception {
		Client client = Client.create();
		WebResource webResource = client.resource(HELLO_URL + "/Max");
		String response = webResource.get(String.class);

		assertThat(response, is("Hello, Max!"));
	}

	@Test
	public void testHelloUserQueryParam() throws Exception {
		Client client = Client.create();
		WebResource webResource = client.resource(HELLO_URL + "?name=Min");
		String response = webResource.get(String.class);

		assertThat(response, is("Hello, Min!"));
	}
}
