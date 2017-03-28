package holinko.HPN.controller;

import holinko.HPN.entity.Customer;
import holinko.HPN.managers.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController
{

    @Autowired
    private UserManager userManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model)
    {
        return "/products";
    }

    @RequestMapping(value = "/accountinfo")
    public String getAccinfo(@RequestParam(value = "name", defaultValue = "") String name, Model model)
    {
        Customer customer = userManager.findUserByName(name);
        model.addAttribute("customer", customer);
        return "accountinfo";
    }
}
