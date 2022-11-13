package local.vtos.controllers;

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
    public String allItems(Model model){

        model.addAttribute("timeTable",timeTableDao.index());
        System.out.println("index");
        return "index";
        //return null;
    }


}
