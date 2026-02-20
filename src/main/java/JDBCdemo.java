import java.sql.*;

public class JDBCdemo {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/basic_sql";
    private static final String userName = "root";
    private static final String password = "Sh@36";

    public static void main(String args[]){

        // type -3 to connection the databasle and close the connection;

        try(Connection con = DriverManager.getConnection(url, userName, password)){
            System.out.println("database connect");

            insertStudent(con, "Aluma", "aliuma@gmail.com");

            updateStudent(con, 1, "shailesh", "shailesh@gmail.com");

            selectStudent(con);

            deletsStudents(con, 1);

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    private static void insertStudent(Connection con, String name, String email){
        String sql = "INSERT INTO student (name, email) VALUE ('"+name +"','"+email+"')";
        try (Statement stmt = con.createStatement()) {
            int rows = stmt.executeUpdate(sql);
            System.out.println("Insert : "+rows);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private static void selectStudent(Connection conn) {
        String sql = "SELECT * FROM student";
        try(Statement stmt = conn.createStatement()) {
            ResultSet resltSet = stmt.executeQuery(sql);
            System.out.println("Student List: ");
            while(resltSet.next()){
                int id = resltSet.getInt("id");
                String name = resltSet.getString("name");
                String email = resltSet.getString("email");
                System.out.println(id + " : " + name + " : " + email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static void updateStudent(Connection conn, int id,String name, String email){
        String sql = "UPDATE student SET name = '"+ name + "', email = '"+ email+"' WHERE id="+id;

        try(Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(sql);
            System.out.println("UPDATED: "+rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deletsStudents(Connection conn, int id){
        String sql = "DELETE FROM student WHERE id = "+id;
        try (Statement stmt = conn.createStatement()){
            int row = stmt.executeUpdate(sql);
            System.out.println("DELECTD: "+ row);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
