package com.fujitsu.ttf.yd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {
	
	@GetMapping("/frontend")
	public String index() {
		return "/frontend/index";
	}
	
	@GetMapping("/backend")
	public String backend() {
		return "/backend/index";
	}

}
