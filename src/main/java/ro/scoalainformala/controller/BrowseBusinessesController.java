package ro.scoalainformala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.scoalainformala.model.SearchWord;

@Controller
public class BrowseBusinessesController {

    @RequestMapping({"/browsebusinesses.html"})
    public String displayBrowsePage(Model model) {

        model.addAttribute("wordbr", new SearchWord());
        return "browsebusinesses.html";
    }

}
