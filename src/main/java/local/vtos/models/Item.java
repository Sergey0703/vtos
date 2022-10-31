package local.vtos.models;

//import lombok.Data;

import lombok.Data;

@Data
public class Item {
    private int id;
    private String name;
    private String description;


    public Item(int id, String name){
        this.id=id;
        this.name=name;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

}
