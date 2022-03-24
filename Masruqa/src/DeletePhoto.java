
public class DeletePhoto implements IDeletePhoto {
	Database database = new Database();
	public void deletePhoto (int num, int id, Photo photo) {
		database.deleteOk(num, id, photo);
	}
}
