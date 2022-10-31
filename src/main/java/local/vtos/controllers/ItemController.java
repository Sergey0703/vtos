package local.vtos.controllers;

import local.vtos.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {

    private final ItemDao itemDao;

    @Autowired
    public ItemController(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @GetMapping()
    public String allItems(Model model){
        model.addAttribute("items",itemDao.index());
        return "items";
        //return null;
    }

    @GetMapping("/{id}")
     public String item(@PathVariable("id") int id, Model model){
        model.addAttribute("item",itemDao.showItem(id));
      return "item";
    }

}
