package local.vtos.models;

//import lombok.Data;

import lombok.Data;

@Data
public class TimeTable {
    private int lesson_id;
    private int item_id;
    //private String name;
    //private String description;

    public TimeTable(){

    }

    public TimeTable(int lesson_id, int item_id){
        this.lesson_id=lesson_id;
        this.item_id=item_id;
    }

    public void setLessonId(int lesson_id){
        this.lesson_id=lesson_id;
    }

    public int getLessonId(){
        return this.lesson_id;
    }

    public void setItemId(int item_id){
        this.item_id=item_id;
    }

    public int getItemId(){
        return this.item_id;
    }
    /*public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    } */

}
