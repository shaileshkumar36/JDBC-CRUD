package org.example;

import java.sql.*;

public class TransactionsDemo {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/basic_sql";
    private static final String USER = "root";
    private static final String PASSWORD = "Sh@36";


    public static void main(String[] args) throws SQLException {
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
            System.out.println("Connected to the Database!");

            // TURNED OFF AUTO COMMIT == NO AUTO SAVE
            conn.setAutoCommit(false);

            try{
                //Order OrderItem
                //INSERT INTO ORDER
                int orderId = insertOrder(conn, 101, "Alice01", 2000.0);

                //INSERT INTO ITEM
                insertOrderItem(conn, orderId, "Laptop01", 1, 20000.00);

                conn.commit();
                System.out.println("Trarsaction Committed Successfully");
            }catch(SQLException e){
                e.printStackTrace();
                conn.rollback();
                System.out.println("Operation rollback successful");
            } finally {
                conn.setAutoCommit(true);
            }

        }

    }

    private static void insertOrderItem(Connection conn, int orderId, String productName, int quality, double prices) {
        String sql = "INSERT INTO orderItem (order_id, product_name, quantity, price) VALUES (?, ?, ?, ?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1,orderId);
            pstmt.setString(2,productName);
            pstmt.setInt(3, quality);
            pstmt.setDouble(4,prices);
            int row = pstmt.executeUpdate();
            System.out.println("INSERTED into orders: "+ row);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int insertOrder(Connection conn, int  customerId, String customerName, double prices) {
        String sql = "INSERT INTO orders (user_id, customer_name, total_amount) VALUES (?, ?, ?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1,customerId);
            pstmt.setString(2,customerName);
            pstmt.setDouble(3,prices);
            int row = pstmt.executeUpdate();
            System.out.println("INSERTED into orders: "+ row);

            try(ResultSet rs = pstmt.getGeneratedKeys()){
                if(rs.next()){
                    int orderId = rs.getInt(1);
                    System.out.println("ORDER ID: "+orderId);
                    return orderId;
                }else {
                    throw new SQLException("Order ID not generated");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
