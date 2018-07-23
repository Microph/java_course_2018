package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoJDBC {
    public static void main(String[] args) {
        DemoJDBC demo = new DemoJDBC();
        demo.countDataFromDatabase(1);
    }
    
    private void countDataFromDatabase(int idIn) {
        //try with resource -> no need to call close
        String sql = "SELECT id, name from USER WHERE id=?";
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://35.240.204.236/sample?user=user01&password=password");
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ){
            preparedStatement.setInt(1, idIn);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.printf("%d -> %s\n", id, name);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

