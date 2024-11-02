package br.com.plusoft.nexus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.plusoft.nexus.empresa.Empresa;
import br.com.plusoft.nexus.empresa.EmpresaRepository;


@Controller
public class HomeController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @RequestMapping("/")
    public String index (Model model) {
        model.addAttribute("msgBemVindo", "Bem-vindo ao Nexus");

        List<Empresa> empresasParceiras = empresaRepository.findAll(); 

        model.addAttribute("empresasParceiras", empresasParceiras);

        return "home";
    }
    
}
