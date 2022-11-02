package com.vitorrubenich.traveler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vitorrubenich.traveler.model.Cliente;
import com.vitorrubenich.traveler.model.UF;
import com.vitorrubenich.traveler.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
    private ClienteRepository clienteRepositorio;

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("cliente/home");

        modelAndView.addObject("clientes", clienteRepositorio.findAll());

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhes(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("cliente/detalhes");

        modelAndView.addObject("cliente", clienteRepositorio.getOne(id));

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("cliente/formulario");

        modelAndView.addObject("cliente", new Cliente());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("cliente/formulario");

        modelAndView.addObject("cliente", clienteRepositorio.getOne(id));
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Cliente cliente) {
        clienteRepositorio.save(cliente);

        return "redirect:/clientes";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable int id) {
        clienteRepositorio.deleteById(id);

        return "redirect:/clientes";
    }
}
