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

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAllLaptops(Model model)
    {
        LOGGER.info("Get all laptops");
        model.addAttribute("storages", shopManager.showLaptops());
        return "products";
    }

    @RequestMapping(value = "/buyProduct", method = RequestMethod.GET)
    public String buyLaptop(@RequestParam(value = "id", defaultValue = "") Long id, Model model)
    {
        if (null != id && id > 0)
        {
            LOGGER.info("Buying laptop");
            shopManager.buyLaptop(id);
        }
        return "products";
    }

    @RequestMapping(value = {"/addproduct", "/deleteproduct"}, method = RequestMethod.GET)
    public String addLaptop(@RequestParam(value = "id", defaultValue = "") Long id, Model model)
    {
        LOGGER.info("Adding laptop");
        shopManager.addLaptop(id);
        return "products";
    }
}
