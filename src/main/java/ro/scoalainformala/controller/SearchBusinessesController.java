package ro.scoalainformala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.scoalainformala.model.SearchWord;


@Controller
public class SearchBusinessesController {

    @RequestMapping({"/", "/searchbusinesses.html", "/index.html"})
    public String displayHomePage(Model model) {

        model.addAttribute("wordsh", new SearchWord());
        return "searchbusinesses.html";
    }

}
