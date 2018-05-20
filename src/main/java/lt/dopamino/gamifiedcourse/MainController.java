package lt.dopamino.gamifiedcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "mainPage";
    }

    @GetMapping("/Kursai")
    public String Kursai() {
        return "Kursai";
    }

}
