package librarysystem_oto;

import java.sql.*;

public class dbHelper {
    private String username = "root";
    private String password = "1234";
    private String dbUrl = "jdbc:mysql://localhost:3306/library_systemdb";
    
    public Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(dbUrl, username, password);
    }
    
    public void showErrorMessage(SQLException exception){
        System.out.println("Error: "+exception.getMessage());
        System.out.println("Error Code:"+ exception.getErrorCode());
    }

}
