package com.york.ws;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.york.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}

}