package com.vitorrubenich.traveler.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vitorrubenich.traveler.model.UF;
import com.vitorrubenich.traveler.model.Usuario;
import com.vitorrubenich.traveler.repository.PermissaoRepository;
import com.vitorrubenich.traveler.repository.UsuarioRepository;
import com.vitorrubenich.traveler.utils.SenhaUtils;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@Autowired
	public PermissaoRepository permissaoRepository;
	
	@GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("usuario/home");

        modelAndView.addObject("usuarios", usuarioRepository.findAll());

        return modelAndView;
    }
	
	@GetMapping("/perfil") 
	public ModelAndView perfil(Principal principal) {
		
		 ModelAndView modelAndView = new ModelAndView("usuario/perfil");
		  
		 Usuario usuario = usuarioRepository.findByEmail(principal.getName()).get();
		 modelAndView.addObject("usuario", usuario);
		 return modelAndView;
	}
	
	

    @GetMapping("/{id}")
    public ModelAndView detalhes(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("usuario/detalhes");

        modelAndView.addObject("usuario", usuarioRepository.getOne(id));

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("usuario/formulario");

        modelAndView.addObject("usuario", new Usuario());
        modelAndView.addObject("permissaos", permissaoRepository.findAll());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("usuario/formulario");

        modelAndView.addObject("usuario", usuarioRepository.getOne(id));
        modelAndView.addObject("permissaos", permissaoRepository.findAll());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Usuario usuario) {
        String senhaEncriptada = SenhaUtils.encode(usuario.getSenha());

        usuario.setSenha(senhaEncriptada);
        usuarioRepository.save(usuario);

        return "redirect:/usuario";
    }

    @PostMapping("/{id}/editar")
    public String editar(Usuario usuario, @PathVariable int id) {
        String senhaAtual = usuarioRepository.getOne(id).getSenha();
        usuario.setSenha(senhaAtual);
        usuarioRepository.save(usuario);

        return "redirect:/usuario";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable int id) {
        usuarioRepository.deleteById(id);

        return "redirect:/usuario";
    }
}
