package com.example.IntegrationTest;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertEquals;

public class HelloApiTest {
    private static String HELLO_URL = "http://localhost:8080";

    @Test
    public void testHello() throws Exception {

        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(HELLO_URL);
        String response = target
                .path("api")
                .path("hello")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        assertEquals(response, "Hello, World!");
    }

    @Test
    public void testHelloUser() throws Exception {

        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(HELLO_URL);
        String response = target
                .path("api")
                .path("hello")
                .path("Max")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        assertEquals(response, "Hello, Max!");
    }

}
