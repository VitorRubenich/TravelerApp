package com.vitorrubenich.traveler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vitorrubenich.traveler.model.Destino;
import com.vitorrubenich.traveler.repository.DestinoRepository;

@Controller
@RequestMapping("/")
public class PagsController {
	
	@Autowired
    private DestinoRepository destinoRepository;

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/layout")
	public String layout() {
		return "layout";
	}
	
	@GetMapping("/destinos")
	public ModelAndView destinos() {
	    ModelAndView modelAndView = new ModelAndView("destinos");

	    modelAndView.addObject("destinos", destinoRepository.findAll());

	    return modelAndView;
	}

	
	@GetMapping("/imagemdestino/{id}")
    @ResponseBody
    public byte[] exibirImagem(@PathVariable("id") Integer id) {
    	Destino destino = destinoRepository.getOne(id);
    	return destino.getImagem();
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
