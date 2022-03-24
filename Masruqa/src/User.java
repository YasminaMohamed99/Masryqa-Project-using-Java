
public class User {
    private String username;
    private String email;
    private String password;
    private String conPassword;
    private String Gender;
    private int id;
    
    public User (String username, String email, String password, String conPassword, String Gender, int id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.conPassword = conPassword;
        this.Gender = Gender;
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getConPassword() {
        return conPassword;
    }
    public int getId() {
        return id;
    }
    public String getGender() {
        return Gender;
    }
}

