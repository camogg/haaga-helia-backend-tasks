package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(@RequestParam(name="name") String name, @RequestParam(name="location") String location) {
		return "Welcome to the " + location + " " + name + "!";
	}
	
}

