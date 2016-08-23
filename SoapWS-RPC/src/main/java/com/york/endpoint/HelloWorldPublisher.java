package com.york.endpoint;

import javax.xml.ws.Endpoint;

import com.york.ws.HelloWorldImpl;
import com.york.ws.PersonServiceImpl;
import com.york.ws.*;

//Endpoint publisher
public class HelloWorldPublisher{

	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());	   
	   Endpoint.publish("http://localhost:9999/ws/person", new PersonServiceImpl());
    }

}