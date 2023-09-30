package com.wd.webdine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	
	@GetMapping("/tester")
	public void Tester() {
		System.out.println("tester");
	}
}
