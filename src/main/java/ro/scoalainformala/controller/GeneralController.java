package ro.scoalainformala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {

    @RequestMapping({"/aboutus.html"})
    public String displayAboutPage() {
        return "aboutus.html";
    }

    @RequestMapping({"/contact.html"})
    public String displayContactPage() {
        return "contact.html";
    }

}
