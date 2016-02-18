package com.example.IntegrationTest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloApiTest {
    private static String HELLO_URL = "http://localhost:8080/api";

    @Test
    public void testHello() throws Exception {
        Client client = Client.create();
        WebResource webResource = client.resource(HELLO_URL);
        String response = webResource.get(String.class);

        assertEquals(response, "Hello, World!");
    }

    @Test
    public void testHelloUser() throws Exception {
        Client client = Client.create();
        WebResource webResource = client.resource(HELLO_URL + "/Max");
        String response = webResource.get(String.class);

        assertEquals(response, "Hello, Max!");
    }

    @Test
    public void testHelloUserQueryParam() throws Exception {
        Client client = Client.create();
        WebResource webResource = client.resource(HELLO_URL + "?name=Min");
        String response = webResource.get(String.class);

        assertEquals(response, "Hello, Min!");
    }
}
