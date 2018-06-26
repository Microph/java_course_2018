package exceptionDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExceptionDemoMain {
    //Demonstrate Business Exceptions
    public String getName(String id) throws UserNotFoundException, InternalException, DatabaseProblemException {
        try {
            Class.forName("mysql.xxx");
            Connection connection = DriverManager.getConnection("url");
            PreparedStatement preparedStatement
            = connection.prepareStatement("SELECT * FROM TABLE");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getString("NAME");
            }
            else {
                throw new UserNotFoundException();
            }
        }
        catch(ClassNotFoundException e) {
            throw new InternalException();
        }
        catch(SQLException e) {
            throw new DatabaseProblemException();
        }
    }
    
    //Test Runtime Exception
    public double testDiv(int a, int b) {
        if(b == 0)
            throw new IllegalDivisionException();
        
        return a / b;
    }
    
    public static void main(String[] args) {
        ExceptionDemoMain exceptionTest = new ExceptionDemoMain();
        System.out.println(exceptionTest.testDiv(1, 0));
    }
}
