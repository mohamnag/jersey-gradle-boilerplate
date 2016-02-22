package com.example.IntegrationTest;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * A sample test class for API resources consuming and returning JSON.
 * Tests are based on examples from Jersey:
 * https://github.com/jersey/jersey/blob/2.22.1/examples/json-jackson/src/test/java/org/glassfish/jersey/examples/jackson/JacksonTest.java
 */
public class HelloApiTest {
    private static String HELLO_URL = "http://localhost:8080";

    @Test
    public void testHello() throws Exception {

        ClientConfig config = new ClientConfig().register(JacksonFeature.class);
        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(HELLO_URL);
        String response = target
                .path("api")
                .path("hello")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        assertThat(response, containsString("\"theWord\""));
        assertThat(response, containsString("\"Hello, World!\""));
    }

    @Test
    public void testHelloUser() throws Exception {

        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        WebTarget target = client.target(HELLO_URL);
        String response = target
                .path("api")
                .path("hello")
                .path("Max")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        assertThat(response, containsString("\"theWord\""));
        assertThat(response, containsString("\"Hello, \""));
        assertThat(response, containsString("\"userName\""));
        assertThat(response, containsString("\"Max\""));
    }

}
