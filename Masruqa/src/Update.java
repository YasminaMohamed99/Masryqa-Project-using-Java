
public class Update implements IUpdatePhoto{
	Database database = new Database();
	public void updatePhoto (int id, int oldNum, int newNum, Photo photo) {
		database.updateOk(id, oldNum, newNum, photo);
	}
}
