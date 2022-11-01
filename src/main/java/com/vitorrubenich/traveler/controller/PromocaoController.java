package com.vitorrubenich.traveler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vitorrubenich.traveler.model.Promocao;
import com.vitorrubenich.traveler.repository.PromocaoRepository;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {

	@Autowired
    private PromocaoRepository promocaoRepository;

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("promocao/home");

        modelAndView.addObject("promocoes", promocaoRepository.findAll());

        return modelAndView;
    }
    
    
    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("promocao/formulario");

        modelAndView.addObject("promocao", new Promocao());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("promocao/formulario");

        modelAndView.addObject("promocao", promocaoRepository.getOne(id));

        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Promocao promocao) {
    	promocao.setValorFinal(promocao.percDesconto);
        promocaoRepository.save(promocao);

        return "redirect:/promocao";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable int id) {
        promocaoRepository.deleteById(id);

        return "redirect:/promocao";
    }
}