import java.sql.*;

public class JDBCdemo {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/basic_sql";
    private static final String userName = "root";
    private static final String password = "Sh@36";

    public static void main(String args[]) {

        // type-1 to connect database we not cloase the connection

        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            System.out.println("DB connected suscessfull");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
