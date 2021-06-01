package my.project.controller;

import my.project.entity.Client;
import my.project.service.entity.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StartController {

    @Autowired
    ClientService clientService;

    @GetMapping(value = "/mvc/start")
    public String startPageUsingModel(Model model) {
        List<Client> clientsList = clientService.readAllClient();
        model.addAttribute("clientsList", clientsList);
        return "start/index";
    }
}
