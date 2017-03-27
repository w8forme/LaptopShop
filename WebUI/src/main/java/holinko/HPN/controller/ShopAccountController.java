package holinko.HPN.controller;

import holinko.HPN.managers.ShopManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by Pavel
 */
@Controller
@RequestMapping("/")
public class ShopAccountController
{
    private static Logger LOGGER = LoggerFactory.getLogger(ShopAccountController.class);

    @Autowired
    private ShopManager shopManager;

    @RequestMapping(value = "/products", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAllLaptops(Model model)
    {
        LOGGER.info("Get all laptops");
        model.addAttribute("storages", shopManager.showLaptops());
        return "/products";
    }

    @RequestMapping(value = {"/buyProduct", "/deleteproduct"}, method = RequestMethod.POST)
    public String buyLaptop(@RequestParam(value = "id", defaultValue = "") Long id, Model model)
    {
        if (null != id && id > 0)
        {
            LOGGER.info("Buying laptop id: " + id);
            shopManager.buyLaptop(id);
        }
        LOGGER.info("Buying laptop id: " + id);
        return "redirect:/products";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String addLaptop(@RequestParam(value = "id", defaultValue = "") Long id, Model model)
    {
        LOGGER.info("Adding laptop");
        shopManager.addLaptop(id);
        return "redirect:/products";
    }

    @RequestMapping(value = "/editproduct", method = RequestMethod.POST)
    public String editLaptop(@RequestParam(value = "id", defaultValue = "") Long id, Model model)
    {
        LOGGER.info("Adding laptop");
        shopManager.addLaptop(id);
        return "redirect:/products";
    }
}
