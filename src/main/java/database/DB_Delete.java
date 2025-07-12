package database;

import java.sql.*;
import java.util.*;

public class DB_Delete {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/selenium";
        String user = "root";
        String password = "";
        Map<String, String> userMap = new HashMap<>();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully!");

            // DELETE
            String deleteSql = "DELETE FROM users WHERE name=?";
            PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
            deleteStmt.setString(1, "Alice");
            deleteStmt.executeUpdate();
            
            System.out.println("Deleted user Alice.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
