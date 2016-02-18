package com.ziroby.hello.webapp;

import com.ziroby.hello.service.HelloWorldService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * This class represents how a POJO can be used to expose functionality
 * of your Service Layer into a web app.
 *
 * TODO: replace this class with similar ones for your demand
 */
@Path("/hello")
public class HelloWebapp {
	private static HelloWorldService helloWorldService = new HelloWorldService();
	
	@GET()
	public String hello() {
		return helloWorldService.sayHello();
	}

	@GET()
	@Path("/{name}")
	public String helloUser(@PathParam("name") String name) {
		return helloWorldService.sayHello(name);
	}

}
