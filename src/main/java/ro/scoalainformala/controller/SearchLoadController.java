package ro.scoalainformala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.scoalainformala.model.SearchWord;
import ro.scoalainformala.service.Search;

@Controller
public class SearchLoadController {

    @GetMapping({"/searchload.html"})
    public String displayServerResponsePage(SearchWord w, Model model) {

        String searchWord = w.getWord();
        String serverResponse = Search.service(searchWord);

        model.addAttribute("wordsh", w);
        model.addAttribute("srres", serverResponse);

        return "searchload.html";
    }

}
