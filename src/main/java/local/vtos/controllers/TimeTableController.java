package local.vtos.controllers;
import local.vtos.models.Item;
import local.vtos.dao.TimeTableDao;
import local.vtos.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TimeTableController {


    private final TimeTableDao timeTableDao;
    private final ItemDao itemDao;

    @Autowired
    public TimeTableController(TimeTableDao timeTableDao, ItemDao itemDao) {
        this.timeTableDao = timeTableDao;
        this.itemDao = itemDao;
    }

    @GetMapping()
    public String allItems(Model model, @ModelAttribute("item") Item item){
        model.addAttribute("item",itemDao.showItem(2));
        model.addAttribute("timeTable",timeTableDao.index());
        model.addAttribute("items",itemDao.index());
        System.out.println("index");
        return "index";
        //return null;
    }


}
