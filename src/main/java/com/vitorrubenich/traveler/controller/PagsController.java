package com.vitorrubenich.traveler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vitorrubenich.traveler.model.Destino;
import com.vitorrubenich.traveler.model.Promocao;
import com.vitorrubenich.traveler.repository.DestinoRepository;
import com.vitorrubenich.traveler.repository.PromocaoRepository;

@Controller
@RequestMapping("/")
public class PagsController {
	
	@Autowired
    private DestinoRepository destinoRepository;
	
	@Autowired
	private PromocaoRepository promocaoRepository;

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

	@GetMapping("/promocoes")
	public ModelAndView promocoes() {
	    ModelAndView modelAndView = new ModelAndView("promocoes");

	    modelAndView.addObject("promocoes", promocaoRepository.findAll());

	    return modelAndView;
	}
	
	
	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}
	
	@GetMapping("/imagemdestino/{id}")
    @ResponseBody
    public byte[] exibirImagem(@PathVariable("id") Integer id) {
    	Destino destino = destinoRepository.getOne(id);
    	return destino.getImagem();
    }
	
	@GetMapping("/imagempromo/{id}")
    @ResponseBody
    public byte[] exibirImagemPromo(@PathVariable("id") Integer id) {
    	Promocao promocao = promocaoRepository.getOne(id);
    	return promocao.getImagem();
    }

}
