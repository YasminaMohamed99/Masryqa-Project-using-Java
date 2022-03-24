import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PhotoInformation implements Iphoto {
	Database database = new Database();

	public void reply(Integer phoneNum, Integer num, String desc, Photo photo) {
		if (!database.validateNum(photo)) {
			try {
				String write = num.toString() + " | " + phoneNum.toString() + " | " + desc;
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Photo #" + num + ".txt", true)));
				out.println(write);
				out.close();

			} catch (IOException e) {
			}
			System.out.println("SUCCESS!\n");
		}
	}

	public ArrayList<String> viewDescription(int num, int id, Photo photo) {
		ArrayList<String> view = new ArrayList<String>();
		if (!database.validateNum(photo)) {
			File read = new File("Photo #" + num + ".txt");
			if (read.exists()) {
				try {
					BufferedReader in = new BufferedReader(new FileReader("Photo #" + num + ".txt"));
					String s;
					while ((s = in.readLine()) != null) {
						view.add(s);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return view;
	}
}
