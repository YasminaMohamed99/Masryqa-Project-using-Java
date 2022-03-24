import java.util.ArrayList;

public interface Iphoto {
	public void reply(Integer phoneNum, Integer num, String desc, Photo photo);
	
	public ArrayList<String> viewDescription(int num, int id, Photo photo);
}
