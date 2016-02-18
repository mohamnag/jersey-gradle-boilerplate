package com.example.services;

import com.example.data_transfer_objects.Hello;
import com.example.data_transfer_objects.HelloUser;

/**
 * This class is actually part of your core code, a kind of Service Layer.
 *
 * TODO: replace this class with your own service layer.
 */
public class HelloWorldService {

	public Hello sayHello() {
		Hello hello = new Hello();
		hello.setTheWord("Hello, World!");

		return hello;
	}

	public Hello sayHelloUser(String name) {
		HelloUser helloUser = new HelloUser(name);

		return helloUser;
	}
}
