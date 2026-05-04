package db;

import java.sql.*;

public class DBUtils {

    private static Connection connection;

    public static void connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/testdb" ;
                   String user =  "root" ;
                   String password =  "pnarsa@123" ;

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("✅ DB Connected");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ;
    }

    public static String getUserName(int userId)  {
        String name = null;
        try{
        String query = "SELECT first_name FROM users WHERE id = " + userId;
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        if (rs.next()) {
            name =  rs.getString("first_name");
            System.out.print("DB name" + name);
        }else {
            System.out.println("❌ No record found for ID: " + userId);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

        return name;

    }

    public static void close()  {
        try {
            connection.close();
            System.out.println("🔌 DB Closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}