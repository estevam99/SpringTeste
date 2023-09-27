/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.exemplosspringmvc;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author joao.veraimundo
 */


@Controller
@RequestMapping("/dados")
public class DadosController {
    @GetMapping("/cad")
    public ModelAndView exemploViewObj() {
         System.out.println("dentro da action cad");
        ModelAndView mv = new ModelAndView("message-view");
        mv.addObject("dados", new Dados());
        return mv;
    }
    
    @PostMapping("/salvar")
    public ModelAndView salvar (
            @ModelAttribute("dados") Dados dadosRecebidos,
            RedirectAttributes redirAttr){
         System.out.println("dentro da action salvar");
        ModelAndView mv = new ModelAndView("redirect:/resultado");
        
        redirAttr.addFlashAttribute("dados", dadosRecebidos);
        
        return mv;
    }
    
    @GetMapping("/result")
    public ModelAndView result( @ModelAttribute Dados dadosRecebidos) {
        System.out.println("dentro da action result");
        ModelAndView mv = new ModelAndView("resultado");
        
        mv.addObject("nome",dadosRecebidos.getNome());
        mv.addObject("email",dadosRecebidos.getEmail());
        mv.addObject("numero",dadosRecebidos.getNumero());
        mv.addObject("senha",dadosRecebidos.getSenha());
        return mv;
    }
    
}
