package ro.scoalainformala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StyleController {

    @RequestMapping({"/style.css"})
    public String displayHomePage() {
        return "style.css";
    }

}
