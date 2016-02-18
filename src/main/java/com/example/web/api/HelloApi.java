package com.example.web.api;

import com.example.data_transfer_objects.Hello;
import com.example.services.HelloWorldService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * This class represents how a POJO can be used to expose functionality
 * of your Service Layer as RESTful web service.
 *
 * Pay attention that this is more or less exposing the same functionality
 * that {@link com.example.web.ui.HelloUi} also exposes but in another
 * form.
 *
 * TODO: replace this class with similar ones for your demand
 */
@Path("/")
public class HelloApi {

    private static HelloWorldService helloWorldService = new HelloWorldService();

    // todo this to return JSON
    @GET()
    public Hello hello() {
        return helloWorldService.sayHello();
    }

    // todo this to return JSON
    @GET()
    @Path("/{name}")
    public Hello helloUser(@PathParam("name") String name) {
        return helloWorldService.sayHelloUser(name);
    }

}
