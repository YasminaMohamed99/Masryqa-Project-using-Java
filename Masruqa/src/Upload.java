
public class Upload implements Iupload {
	Database database = new Database();
	public void upload(Photo photo) {
		database.insertOk(photo);
	}
}
