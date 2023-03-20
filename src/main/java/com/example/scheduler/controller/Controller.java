package com.example.scheduler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	@GetMapping("/some")
	public void some() {
		System.out.println("adsdaw");
	}
}
