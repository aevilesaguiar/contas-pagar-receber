package br.com.aeviles.contas.controller;

import br.com.aeviles.contas.model.Contas;
import br.com.aeviles.contas.services.ContasService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contas") //é usada para mapear solicitações HTTP para métodos manipuladores de controladores MVC e REST . Em aplicações Spring MVC,
public class ContaController {

    private ContasService contasService;

    @RequestMapping("listar")
    public String index(Model model){

        /**
         * Lista completa de todas as contas
         */
       List<Contas> contas=contasService.listAll();

       // model.addAttribute("listContas", listContas);

        return "index";//view
            }



}
