import java.util.ArrayList;

public class Search implements Isearch{
	Database database = new Database();
	public ArrayList<Integer> search(Photo photo) {
		ArrayList<Integer> returnNums = database.search(photo);
		return returnNums;
	}
}
