import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegisteration implements IRegisteration {
    Database database = new Database();
    DBConnection db = new DBConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public boolean login (String email, String password) {
    	boolean isTrue = false;
        if (database.validateLogin(email, password)) {
            db.connection();
            String sql = "INSERT INTO login (email, password) VALUES (?, ?)";
            try
            {
                stmt = db.conn.prepareStatement(sql);
                stmt.setString(1, email);
                stmt.setString(2, password);
                stmt.executeUpdate();
                System.out.println("SUCCESS!\n");
                isTrue = true;
            }
            catch (SQLException e) {}
        } else {
            System.out.println("Invalid email and password\n");
            isTrue = false;
        }
        return isTrue;
    }
    
    public boolean signUp (User user) {
    	boolean isTrue = false;
        if (database.validateSignUp(user)) {
            db.connection();
            String sql = "INSERT INTO signup (name, email, password, conPassword, gender, id) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                stmt = db.conn.prepareStatement(sql);
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getEmail());
                stmt.setString(3, user.getPassword());
                stmt.setString(4, user.getConPassword());
                stmt.setString(5, user.getGender());
                stmt.setInt(6, user.getId());
                stmt.executeUpdate(); 

                System.out.println(" SUCCESS!\n");
                isTrue = true;

            } catch(SQLException se) {}
        } else {
            System.out.println("ID or Email is Already Exist");
            isTrue = false;
        }
        return isTrue;
    }
    
    public void logout (String email) {
        database.deleteLogin(email);
    }
}
