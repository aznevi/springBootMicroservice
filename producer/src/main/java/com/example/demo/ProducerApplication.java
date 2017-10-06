package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController 
@RefreshScope
public class ProducerApplication {
	
	@Value("${server.port}")
	private int port;
	
	@Value("${test.message}")
    private String msg;
	
	@RequestMapping(method=RequestMethod.GET,path="/serverinfo")
	public String serverInfo(){
		return "My port : "+ port;
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/testfeign")
	public String testfeign(@RequestParam("name") String name,@RequestParam("surname") String surname){
		return "Hello  : "+name+ surname;
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/msg")
    public String showMsg(){
        return "Hello  : "+this.msg;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}
}
