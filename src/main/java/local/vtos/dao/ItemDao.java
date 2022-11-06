package local.vtos.dao;
import local.vtos.models.Item;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemDao {
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



    public List <Item> index() {
        List <Item> itemDaoList=new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL="SELECT * FROM items";

            ResultSet resultSet=statement.executeQuery(SQL);
            while (resultSet.next()){
              Item item =new Item();
              item.setId(resultSet.getInt("id"));
              item.setName(resultSet.getString("name"));
              itemDaoList.add(item);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return itemDaoList;
    }

    public Item showItem(int id){
      //  return itemDaoList.stream().filter(item -> item.getId()==id).findAny().orElse(null);
        Item item=null;
        try {
            PreparedStatement preparedStatement=
                    connection.prepareStatement("SELECT * FROM items WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();

            item=new Item();
            item.setId(resultSet.getInt("id"));
            item.setName(resultSet.getString("name"));

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }

        return item;
    }

    public void save(Item item){
      //  item.setId(10);
      //  itemDaoList.add(item);
     /*   try {
            Statement statement=connection.createStatement();
            String SQL="INSERT INTO items VALUES(" + 3 + ",'" + item.getName()+"')";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       */
        try {
            PreparedStatement preparedStatement=
                    connection.prepareStatement("INSERT INTO items(name) VALUES(?)");
            preparedStatement.setString(1, item.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
           // e.printStackTrace();
        }


    }

    public void update(int id, Item updateItem){
     //   Item itemToBeUpdated=showItem(id);
     //   itemToBeUpdated.setName(updateItem.getName());

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

    public void delete(int id){
       // itemDaoList.removeIf(p->p.getId()==id);
        PreparedStatement preparedStatement=null;

        try {
            PreparedStatement statement = preparedStatement =
                    connection.prepareStatement("DELETE FROM items WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
