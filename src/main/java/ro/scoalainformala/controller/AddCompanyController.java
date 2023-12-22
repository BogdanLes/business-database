package ro.scoalainformala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.scoalainformala.model.Company;

@Controller
public class AddCompanyController {

    @RequestMapping({"/addcompany.html"})
    public String displayAddCompanyPage(Model model) {

        model.addAttribute("bss", new Company());
        return "addcompany.html";
    }

}
