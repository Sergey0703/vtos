package local.vtos.controllers;

import local.vtos.dao.ItemDao;
import local.vtos.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemDao itemDao;

    @Autowired
    public ItemController(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @GetMapping()
    public String allItems(Model model){
        model.addAttribute("items",itemDao.index());
        return "items/items";
        //return null;
    }

    @GetMapping("/{id}")
     public String item(@PathVariable("id") int id, Model model){
        model.addAttribute("item",itemDao.showItem(id));
      return "items/item";
    }

    @GetMapping("/new")
    public String newItem(Model model){
        model.addAttribute("item", new Item());
        return "items/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("item") Item item){
        itemDao.save(item);
       return "redirect:/items";
       // return null;
    }

}
