import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection conn = null;
    public String DBName = "softdatabase1";
    public String password = "root1234";
    public String username = "root";
    public String host = "jdbc:mysql://localhost:3306/" + DBName + "?autoReconnect=true&useSSL=false";
    public String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public void connection() {
        try {
            Class.forName(JDBC_DRIVER);
            //System.out.println("\nConnecting to database...");
            conn = DriverManager.getConnection(host, username, password);
            } catch (ClassNotFoundException | SQLException ex) {
            }
            //System.out.println("Connected!\n");
    }
}
