package br.com.plusoft.nexus;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String index (Model model) {
        model.addAttribute("msgBemVindo", "Bem-vindo ao Nexus.");
        return "home";
    }
    
}
