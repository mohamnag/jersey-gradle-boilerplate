package com.example.IntegrationTest;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class HelloUiTest {
    private static String HELLO_URL = "http://localhost:8080/";

    @Test
    public void testHello() throws Exception {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(HELLO_URL);
        String response = target
                .path("ui")
                .path("hello")
                .request()
                .accept(MediaType.TEXT_HTML)
                .get(String.class);

        assertThat(response, containsString("Hello, World!"));
    }

    @Test
    public void testHelloUser() throws Exception {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(HELLO_URL);
        String response = target
                .path("ui")
                .path("hello")
                .path("Max")
                .request()
                .accept(MediaType.TEXT_HTML)
                .get(String.class);

        assertThat(response, containsString("Hello,"));
        assertThat(response, containsString("Max"));
    }

}
