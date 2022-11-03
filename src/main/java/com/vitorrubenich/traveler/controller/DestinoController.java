package com.vitorrubenich.traveler.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vitorrubenich.traveler.model.Destino;
import com.vitorrubenich.traveler.repository.DestinoRepository;

@Controller
@RequestMapping("/destino")
public class DestinoController {

	@Autowired
    private DestinoRepository destinoRepository;

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("destino/home");

        modelAndView.addObject("destinos", destinoRepository.findAll());

        return modelAndView;
    }
    
    
    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("destino/formulario");

        modelAndView.addObject("destino", new Destino());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("destino/formulario");

        modelAndView.addObject("destino", destinoRepository.getOne(id));

        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Destino destino, @RequestParam("fileDestino") MultipartFile file) {
        try {
			destino.setImagem(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	destinoRepository.save(destino);

        return "redirect:/destino";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable int id) {
        destinoRepository.deleteById(id);

        return "redirect:/destino";
    }
    // servico para enviar imagem
    
    @GetMapping("/imagemdestino/{id}")
    @ResponseBody
    public byte[] exibirImagem(@PathVariable("id") Integer id) {
    	Destino destino = destinoRepository.getOne(id);
    	return destino.getImagem();
    }
}
