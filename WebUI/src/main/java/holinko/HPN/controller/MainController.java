package holinko.HPN.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model)
    {
        return "redirect:/products";
    }

    @RequestMapping(value = "/accountinfo")
    public String getAccinfo(Model model)
    {
        return "accountinfo";
    }
}
