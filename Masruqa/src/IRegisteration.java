
public interface IRegisteration {
	public boolean login (String email, String password);
		
	public boolean signUp (User user);
		
	public void logout (String email);
		
	
}
