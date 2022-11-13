package local.vtos.dao;
import local.vtos.models.TimeTable;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TimeTableDao {
 /*   private List<Item> itemDaoList;
    {
        itemDaoList = new ArrayList<>();
        itemDaoList.add(new Item(1,"Common"));
        itemDaoList.add(new Item(2,"KK"));
    }
*/

    private static final String URL="jdbc:postgresql://localhost:5432/vtos";
    private static final String USERNAME="postgres";
    private static final String PASSWORD="postgres";

    private static Connection connection;
    static {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public List <TimeTable> index() {
        List <TimeTable> timeTableDaoList=new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL="SELECT * FROM timetable JOIN items ON timetable.item_id=items.id ";

            ResultSet resultSet=statement.executeQuery(SQL);
            while (resultSet.next()){
              TimeTable timeTable =new TimeTable();
              timeTable.setLessonId((resultSet.getInt("lesson_id")));
              timeTable.setItemId(resultSet.getInt("item_id"));
              //timeTable.setItemName(resultSet.getInt("item_id"));
              timeTableDaoList.add(timeTable);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return timeTableDaoList;
    }

    public TimeTable showTimeTable(int id){
      //  return itemDaoList.stream().filter(item -> item.getId()==id).findAny().orElse(null);
        TimeTable timeTable=null;
        try {
            PreparedStatement preparedStatement=
                    connection.prepareStatement("SELECT * FROM timetable WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();

            timeTable=new TimeTable();
            timeTable.setLessonId(resultSet.getInt("lesson_id"));
            timeTable.setItemId(resultSet.getInt("item_id"));

            //timeTable.setName(resultSet.getString("name"));

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }

        return timeTable;
    }

    public void save(TimeTable timeTable){

        try {
            PreparedStatement preparedStatement=
                    connection.prepareStatement("INSERT INTO timeTable(item_id) VALUES(?)");
            preparedStatement.setInt(1, timeTable.getItem_id());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
           // e.printStackTrace();
        }


    }

  /*  public void update(int id, Item updateItem){

        try {
            PreparedStatement preparedStatement=
                    connection.prepareStatement("UPDATE items SET name =? WHERE id=?");
            preparedStatement.setString(1, updateItem.getName());

            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
*/
    public void delete(int id){
       // itemDaoList.removeIf(p->p.getId()==id);
        PreparedStatement preparedStatement=null;

        try {
            PreparedStatement statement = preparedStatement =
                    connection.prepareStatement("DELETE FROM timetable WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
