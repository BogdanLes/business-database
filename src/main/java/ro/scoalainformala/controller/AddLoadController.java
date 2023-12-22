package ro.scoalainformala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import ro.scoalainformala.model.Company;
import ro.scoalainformala.service.AddCompany;

@Controller
public class AddLoadController {

    @PostMapping("/addload.html")
    public String displayServerResponseAddCompany(Company firm, Model model) {

        String name = firm.getName();
        String website = firm.getWebsite();
        String country = firm.getCountry();
        String description = firm.getDescription();
        String founded = firm.getFounded();
        String industry = firm.getIndustry();
        String employees = firm.getEmployees();

        String sres = AddCompany.service(name, website, country, description, founded, industry, employees);

        model.addAttribute("srres", sres);
        return "addload.html";
    }

}
