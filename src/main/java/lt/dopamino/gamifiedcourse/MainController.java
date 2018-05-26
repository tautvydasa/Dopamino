package lt.dopamino.gamifiedcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "redirect:/login";
    }

    @GetMapping("/main")
    public String openMainPage() {
        return "Teacher/Views/MainPage";
    }

}
