package local.vtos.controllers;

import local.vtos.dao.ItemDao;
import local.vtos.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/themes")
public class ThemeController {

    private final ItemDao itemDao;

    @Autowired
    public ThemeController(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @GetMapping()
    public String allItems(Model model){
        //model.addAttribute("items",itemDao.index());
        return "themes/themes";
        //return null;
    }

 /*   @GetMapping("/theme")
    public String newItem(Model model){
       // model.addAttribute("item", new Item());
        return "themes/theme";
    }
*/
    @GetMapping("/theme2")
    public String newItem(Model model){
        // model.addAttribute("item", new Item());
        return "themes/theme2";
    }

}
