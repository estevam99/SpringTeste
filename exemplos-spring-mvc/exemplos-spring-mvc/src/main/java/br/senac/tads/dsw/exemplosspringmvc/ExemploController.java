/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.exemplosspringmvc;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/exemplo")
public class ExemploController {

    @GetMapping("/mensagem1")
    public String saudar1(Model modelo) {
        return "message-view";
    }

    @GetMapping("/mensagem2")
    public ModelAndView saudar2() {
        return new ModelAndView("message-view");
    }

    @GetMapping("/exemplo-request-param")
    public ModelAndView exemploRequestParam(
            @RequestParam(value = "param1str", required = true, defaultValue = "valor") String param1,
            @RequestParam(value = "param2int", required = false, defaultValue = "99") int param2) {
        ModelAndView resposta = new ModelAndView("message-view");
        return resposta;
    }
    

    
    @GetMapping("/exemplo-path-var/{param1str}/{param2int}")
    public ModelAndView exemploPathVariable(
            @PathVariable(value = "param1str",required = true) String param1,
            @PathVariable(value = "param2int",required = true) int param2){
            
        ModelAndView resposta = new ModelAndView("message-view");
        return resposta;
        }
    
    @GetMapping("/exemplo-view-obj")
    public ModelAndView exemploViewObj() {
        ModelAndView mv = new ModelAndView("message-view");
        mv.addObject("texto","Texto gerado no controller v2");
        mv.addObject("numero",100);
        mv.addObject("dataHora",LocalDateTime.now());
        return mv;
    }
}
