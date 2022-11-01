package com.vitorrubenich.traveler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vitorrubenich.traveler.model.Permissao;
import com.vitorrubenich.traveler.repository.PermissaoRepository;

@Controller
@RequestMapping("/permissao")
public class PermissaoController {

	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("permissao/home");

        modelAndView.addObject("permissoes", permissaoRepository.findAllByOrderByIdAsc());

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("permissao/formulario");

        modelAndView.addObject("permissao", new Permissao());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("permissao/formulario");

        modelAndView.addObject("permissao", permissaoRepository.getOne(id));

        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Permissao permissao) {
        permissaoRepository.save(permissao);

        return "redirect:/permissao";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable int id) {
        permissaoRepository.deleteById(id);

        return "redirect:/permissao";
    }
}
