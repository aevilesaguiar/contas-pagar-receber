package br.com.aeviles.contas.controller;

import br.com.aeviles.contas.model.Contas;
import br.com.aeviles.contas.services.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contas") //é usada para mapear solicitações HTTP para métodos manipuladores de controladores MVC e REST . Em aplicações Spring MVC,
public class ContaController {

    @Autowired
    private ContasService contasService;

    @RequestMapping("listar")
    public String index(Model model){

     //Lista completa de todas as contas
       List<Contas> listContas=contasService.listAll();

        model.addAttribute("listContas", listContas );

        //view
        return "index";
            }

    //adicionar
    @RequestMapping("adicionar")
    public ModelAndView add(Contas conta){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("adicionar");
        modelAndView.addObject("conta",conta);//aqui temos adicionar também o attributo name

        return modelAndView;
    }

    @RequestMapping(value="save", method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("conta") Contas conta, BindingResult result){// com o BindingResult eu tenho a possibilidade de verificar se tem erros

    //validação
        if(result.hasErrors()){
            //existe erro? se existe erro eu chamo o add
            return add(conta); //é o objeto que está atrelado ao formulario
        }

        contasService.save(conta);

        ModelAndView mv= new ModelAndView("redirect:/contas/listar");//através do redirect ele indica a url
        return mv;

    }

    @RequestMapping ("/delete/{id}")
    public  ModelAndView delete(@PathVariable("id") Long id ){

        contasService.deleteConta(id);

        ModelAndView mv= new ModelAndView("redirect:/contas/listar");//através do redirect ele indica a url
        return mv;
    }

    @RequestMapping ("/editar/{id}")
    public  ModelAndView editar(@PathVariable("id") Long id ){
        return add(contasService.getContaId(id));
    }


}
