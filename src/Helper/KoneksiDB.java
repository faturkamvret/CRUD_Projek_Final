package Helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KoneksiDB {
    private static Connection con;

    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mental", "root", "");
                System.out.println("berhasil");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("Error DB: " + ex.getMessage());
            }
        }
        return con;
    }

    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error closing connection: " + ex.getMessage());
            }
        }
    }
}

    
