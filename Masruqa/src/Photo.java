
public class Photo {
	private String type;
	private String name;
	private int num;
	private int id;	
	
	public Photo(String type, String name, int num, int id) {
		this.type = type;
		this.name  = name;
		this.num = num;
		this.id = id;
	}
	
	public Photo(int num, int id) {
		this.num = num;
		this.id = id;
	}
	
	public Photo(String name, int num) {
		this.name = name;
		this.num = num;
	}
	
	public Photo(int num) {
		this.num = num;
	}
	
	public Photo(String type) {
		this.type = type;
	}
	
	public Photo() {}
	
	public String getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNum() {
		return num;
	}
	
	public int getId() {
		return id;
	}
}
