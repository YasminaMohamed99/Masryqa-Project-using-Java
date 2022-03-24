import java.util.ArrayList;

public interface Idatabase {

	public void insertOk (Photo photo);
	
	public void updateOk(int id, int oldNum, int newNum, Photo photo);
	
	public void deleteOk(int num, int id, Photo photo);
	
	public ArrayList<Integer> search(Photo photo);
		
	public boolean validateLogin (String email, String password);
			
	public boolean validateSignUp (User user);	
	
	public String selectName (String email);
	
	public String selectEmail (int id);
	
	public int selectUserID (int num);
	
	public String selectType (int num);
	
	public void deleteLogin(String email);
	
	public boolean validateID (Photo photo);;
	
	public boolean validateNum (Photo photo);
}
