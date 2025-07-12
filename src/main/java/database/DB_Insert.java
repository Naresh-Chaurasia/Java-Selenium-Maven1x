package database;

import java.sql.*;

public class DB_Insert {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/selenium";
        String user = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully!");

            // CREATE
            String insertSql = "INSERT INTO users (name, email) VALUES (?, ?)";

            PreparedStatement insertStmt = connection.prepareStatement(insertSql);
            insertStmt.setString(1, "Alice1");
            insertStmt.setString(2, "alice1@example.com");
            insertStmt.executeUpdate();

            System.out.println("Inserted user Alice.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
