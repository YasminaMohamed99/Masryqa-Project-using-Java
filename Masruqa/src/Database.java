import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Database implements Idatabase {
    PreparedStatement stmt = null;
    static DBConnection db = new DBConnection();
    static Photo photo = new Photo();
    
    public boolean validateSignUp (User user) {
        boolean isFound = false;
        db.connection();
        String sql = "select * from signup where email = ? or id = ?";
        try
        {
            stmt = db.conn.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            stmt.setInt(2, user.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                isFound = false;
            } else {
                isFound = true;
            }
        }
        catch (SQLException e) {}
        
        return isFound;
    }
    public boolean validateLogin (String email, String password) {
        boolean isFound = false;
        db.connection();
        String sql = "select * from signup where email = ? and password = ?";
        try
        {
            stmt = db.conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                isFound = true;
            } else {
                isFound = false;
            }
        }
        catch (SQLException e) {}
        
        return isFound;
    }
    
    public void deleteLogin(String email) {
    	db.connection();
        try {
            String sql = "DELETE FROM login WHERE email = ?";
            stmt = db.conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.executeUpdate();
        } catch (SQLException ex) {}
    }
    
    public String selectName (String email) {
        String Name = "";
        db.connection();
        String sql = "SELECT name FROM signup WHERE email = ?";
        try {
                stmt = db.conn.prepareStatement(sql);
                stmt.setString(1, email);
                ResultSet rs = stmt.executeQuery();
                if (rs.next())
                    Name = rs.getString("name");
            } catch (SQLException ex) {}
        return Name;
    }
    
    public boolean validateID (Photo photo) {
        boolean isFound = false;
        db.connection();
        String sql = "select * from signup where id = ?";
        try
        {
            stmt = db.conn.prepareStatement(sql);
            stmt.setInt(1, photo.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                isFound = true;
            } else {
                isFound = false;
            }
        }
        catch (SQLException e) {}
        
        return isFound;
    }
    
    public boolean validateNum (Photo photo) {
        boolean isFound = false;
        db.connection();
        String sql = "select * from photo where num = ?";
        try
        {
            stmt = db.conn.prepareStatement(sql);
            stmt.setInt(1, photo.getNum());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                isFound = false;
            } else {
                isFound = true;
            }
        }
        catch (SQLException e) {}
        
        return isFound;
    }
    
    public String selectEmail (int id) {
        String Email = "";
        db.connection();
        String sql = "SELECT email FROM signup WHERE id = ?";
        try {
                stmt = db.conn.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next())
                	Email = rs.getString("email");
            } catch (SQLException ex) {}
        return Email;
    }
    
    public int selectUserID (int num) {
        int ID = 0;
        db.connection();
        String sql = "SELECT id FROM photo WHERE num = ?";
        try {
                stmt = db.conn.prepareStatement(sql);
                stmt.setInt(1, num);
                ResultSet rs = stmt.executeQuery();
                if (rs.next())
                	ID = rs.getInt("id");
            } catch (SQLException ex) {}
        return ID;
    }
    
    public String selectType (int num) {
        String type = "";
        db.connection();
        String sql = "SELECT type FROM photo WHERE num = ?";
        try {
                stmt = db.conn.prepareStatement(sql);
                stmt.setInt(1, num);
                ResultSet rs = stmt.executeQuery();
                if (rs.next())
                	type = rs.getString("type");
            } catch (SQLException ex) {}
        return type;
    }
    
    public void deleteOk(int num, int id, Photo photo) {
	    	db.connection();
	        try {
	            String sql = "DELETE FROM photo WHERE num = ?";
	            stmt = db.conn.prepareStatement(sql);
	            stmt.setInt(1, num);
	            stmt.executeUpdate();
	            System.out.println("DELETED!\n");
	        } catch (SQLException ex) {}
    }
    
    public void insertOk (Photo photo) {
    	if (validateNum(photo)) {
			db.connection();
	        String sql = "INSERT INTO photo (type, name, num, id) VALUES (?, ?, ?, ?)";
	        try
	        {
	            stmt = db.conn.prepareStatement(sql);
	            stmt.setString(1, photo.getType());
	            stmt.setString(2, photo.getName());
	            stmt.setInt(3, photo.getNum());
	            stmt.setInt(4, photo.getId());
	            stmt.executeUpdate();
	            System.out.println("ULPOADED!\n");
	        }
	        catch (SQLException e) {}
    	}
    }
    
    public void updateOk(int id, int oldNum, int newNum, Photo photo) {
    	if (!validateNum(photo)) {
    		photo = new Photo(newNum);
    		if (validateNum(photo)) {
				db.connection();
		        String sql = "UPDATE photo SET num = ? WHERE num = ?";
		        try
		        {
		            stmt = db.conn.prepareStatement(sql);
		            stmt.setInt(1,newNum);
		            stmt.setInt(2,oldNum);
		            stmt.executeUpdate();
		            System.out.println("UPDATED!\n");
		        }
		        catch (SQLException e) {}
    		}
    	}
    }
    
    public ArrayList<Integer> search(Photo photo) {
    	ArrayList<Integer> returnNums = new ArrayList<Integer>();
    	db.connection();
        String sql = "SELECT * FROM photo WHERE type = ?";
        try
        {
            stmt = db.conn.prepareStatement(sql);
            stmt.setString(1, photo.getType());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	System.out.println("\n" + rs.getString("name") + ": " 
            			+ rs.getInt("num") + "\n");
                returnNums.add(rs.getInt("num"));
            }
        }
        catch (SQLException e) {}
        return returnNums;
    }
}



