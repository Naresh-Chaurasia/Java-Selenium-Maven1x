package database;

import java.sql.*;
import java.util.*;

public class DB_Fetch {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/selenium";
        String user = "root";
        String password = "";
        Map<String, String> userMap = new HashMap<>();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully!");

            String selectSql = "SELECT * FROM users where id < 0";
            Statement selectStmt = conn.createStatement();

            ResultSet rs = selectStmt.executeQuery(selectSql);
            System.out.println("User List:");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " +
                        rs.getString("name") + ", " +
                        rs.getString("email"));

                userMap.put(rs.getString("name"), rs.getString("email"));
            }

            System.out.println("User Map: " + userMap);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
