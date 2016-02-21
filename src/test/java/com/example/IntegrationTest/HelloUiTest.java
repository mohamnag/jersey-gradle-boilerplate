package com.example.IntegrationTest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class HelloUiTest {
    private static String HELLO_URL = "http://localhost:8080/ui";

    @Test
    public void testHello() throws Exception {
        Client client = Client.create();
        WebResource webResource = client.resource(HELLO_URL + "/hello");
        String response = webResource.get(String.class);

        assertThat(response, containsString("Hello, World!"));
    }

    @Test
    public void testHelloUser() throws Exception {
        Client client = Client.create();
        WebResource webResource = client.resource(HELLO_URL + "/hello/Max");
        String response = webResource.get(String.class);

        assertThat(response, containsString("Hello,"));
        assertThat(response, containsString("Max"));
    }

}
