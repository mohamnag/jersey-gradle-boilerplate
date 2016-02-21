package com.example.web.ui;

import com.example.data_transfer_objects.Hello;
import com.example.services.HelloWorldService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;

/**
 * This class represents how a POJO can be used to expose functionality
 * of your Service Layer into a web UI.
 *
 * <p>Pay attention that this is more or less exposing the same functionality
 * that {@link com.example.web.api.HelloApi} also exposes but in another
 * form.
 *
 * TODO: replace this class with similar ones for your demand
 */
@Path("/")
public class HelloUi extends BaseUi {

    private static HelloWorldService helloWorldService = new HelloWorldService();

    @GET()
    public String index() throws IOException {
        return renderTemplate("index", "hello index");
    }

    @GET()
    @Path("/hello/")
    public String hello() throws IOException {
        Hello context = helloWorldService.sayHello();

        return renderTemplate("hello", "just hello!", "helloObject", context);
    }

    @GET()
    @Path("/hello/{name}")
    public String helloUser(@PathParam("name") String name) throws IOException {
        Hello context = helloWorldService.sayHelloUser(name);

        return renderTemplate("helloUser", "hello user!", "helloObject", context);
    }

}
