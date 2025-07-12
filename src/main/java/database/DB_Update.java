package database;

import java.sql.*;
import java.util.*;

public class DB_Update {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/selenium";
        String user = "root";
        String password = "";
        Map<String, String> userMap = new HashMap<>();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully!");

            String updateSql = "UPDATE users SET email=? WHERE id=? ";

            PreparedStatement updateStmt = conn.prepareStatement(updateSql);

            updateStmt.setString(1, "alice_updated@newdomain.com");
            updateStmt.setInt(2, 1);

            updateStmt.executeUpdate();
            System.out.println("Updated Alice's email.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
