package local.vtos.dao;
import local.vtos.models.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemDao {
    private List<Item> itemDaoList;

    {
        itemDaoList = new ArrayList<>();
        itemDaoList.add(new Item(1,"Common"));
        itemDaoList.add(new Item(2,"KK"));
    }

    public List <Item> index(){
        return itemDaoList;
    }

    public Item showItem(int id){
        return itemDaoList.stream().filter(item -> item.getId()==id).findAny().orElse(null);
    }

    public void save(Item item){
        item.setId(10);
        itemDaoList.add(item);
    }
}
