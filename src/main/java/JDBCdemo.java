import java.sql.*;

public class JDBCdemo {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/basic_sql";
    private static final String userName = "root";
    private static final String password = "Sh@36";

    public static void main(String args[]){

        // type -3 to connection the databasle and close the connection;

        try(Connection con = DriverManager.getConnection(url, userName, password)){
            System.out.println("database connect");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
