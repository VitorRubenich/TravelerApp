package com.vitorrubenich.traveler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PagsController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/layout")
	public String layout() {
		return "layout";
	}
	
	@GetMapping("/destinos")
	public String destinos() {
		return "destinos";
	}
	
	@GetMapping("/promocoes")
	public String promocoes() {
		return "promocoes";
	}
	
	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}
	

}
