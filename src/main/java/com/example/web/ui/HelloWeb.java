package com.example.web.ui;

import com.example.services.HelloWorldService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * This class represents how a POJO can be used to expose functionality
 * of your Service Layer into a web UI.
 *
 * Pay attention that this is more or less exposing the same functionality
 * that {@link com.example.web.api.HelloApi} also exposes but in another
 * form.
 *
 * TODO: replace this class with similar ones for your demand
 */
@Path("/")
public class HelloWeb {

    private static HelloWorldService helloWorldService = new HelloWorldService();

    @GET()
    public String hello() {
        return helloWorldService.sayHello().toString();
    }

    @GET()
    @Path("/{name}")
    public String helloUser(@PathParam("name") String name) {
        return helloWorldService.sayHelloUser(name).toString();
    }

}
