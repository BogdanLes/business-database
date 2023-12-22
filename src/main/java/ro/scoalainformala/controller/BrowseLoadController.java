package ro.scoalainformala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.scoalainformala.model.SearchWord;
import ro.scoalainformala.service.Browse;

@Controller
public class BrowseLoadController {
    @GetMapping({"/browseload.html"})
    public String displayServerResponseBrowsePage(SearchWord w, Model model) {

        String country = w.getWord();
        String serverResponse = Browse.service(country);

        model.addAttribute("wordbr", w);
        model.addAttribute("srres", serverResponse);
        return "browseload.html";
    }

}
