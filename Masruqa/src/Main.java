import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner stringScan = new Scanner(System.in);
	static Scanner intScan = new Scanner(System.in);
	
	public static void HomePage(String email) {
		UserRegisteration user = new UserRegisteration();
		PhotoInformation photoInf = new PhotoInformation();
		Upload upload = new Upload();
		DeletePhoto delete = new DeletePhoto();
		Update update = new Update();
		Search search = new Search();
	    Database database = new Database();
	    Photo photo = null;
	    String type, photoName; int photoNum = 0; int userID = 0;
	    String returnEmail;
	    String Name = null;
	    int returnID = 0;
	    int newNum = 0;
	    Integer phoneNumber = 0;
	    ArrayList<String>  descriptions = new ArrayList<String>();
	    ArrayList<Integer> returnNums = new ArrayList<Integer>();
	   
	    
	    Name = database.selectName(email);
        System.out.println("Hello " + Name);
        System.out.println();
        while (true) {
        	System.out.println("To upload => 1:");
        	System.out.println("To delete => 2:");
        	System.out.println("To update => 3:");
        	System.out.println("To search => 4:");
        	System.out.println("To view Descriptions => 5:");
            System.out.println("To logout => 0:");
            System.out.print(">> ");
            int c = intScan.nextInt();
            if (c == 0) {
                user.logout(email);
                break;
            } else if (c == 1) {
            	System.out.print("Type: ");
            	type = stringScan.nextLine();
            	
            	System.out.print("Photo Name: ");
            	photoName = stringScan.nextLine();
            	
            	System.out.print("Photo Number: ");
                photoNum = intScan.nextInt();
                photo = new Photo(photoNum);
                
            	while (!database.validateNum(photo)) {
            		System.out.println("\nAlready exist!\n");
	            	System.out.print("Enter another number: ");
	                photoNum = intScan.nextInt();
	                photo = new Photo(photoNum);
            	}
            	
            	System.out.print("Your ID: ");
                userID = intScan.nextInt();
                photo = new Photo(photoNum, userID);
                returnEmail = database.selectEmail(userID);
                
                while (!database.validateID(photo) || !email.equals(returnEmail)) {
                	System.out.println("\nInvalid ID!\n");
	                System.out.print("Enter your ID: ");
	                userID = intScan.nextInt();
	                photo = new Photo(photoNum, userID);
	                returnEmail = database.selectEmail(userID);
                }
                
                photo = new Photo(type, photoName, photoNum, userID);
                upload.upload(photo);
            } else if (c == 2) {
            	System.out.print("Your ID: ");
            	userID = intScan.nextInt();
            	photo = new Photo(photoNum, userID);
            	returnEmail = database.selectEmail(userID);
            	
            	while (!database.validateID(photo) || !email.equals(returnEmail)) {
            		System.out.println("\nInvalid ID!\n");
            		System.out.print("Enter your ID: ");
            		userID = intScan.nextInt();
            		photo = new Photo(photoNum, userID);
            		returnEmail = database.selectEmail(userID);
            	}
            	System.out.print("Photo Number: ");
                photoNum = intScan.nextInt();
                photo = new Photo(photoNum);
                
                returnID = database.selectUserID(photoNum);
            	if (userID == returnID)
            		delete.deletePhoto(photoNum, userID, photo);
            	else
            		System.out.println("Not found!\n");
            } else if (c == 3) {
            	System.out.print("Your ID: ");
            	userID = intScan.nextInt();
            	photo = new Photo(photoNum, userID);
            	returnEmail = database.selectEmail(userID);
            	
            	while (!database.validateID(photo) || !email.equals(returnEmail)) {
            		System.out.println("\nInvalid ID!\n");
            		System.out.print("Enter your ID: ");
            		userID = intScan.nextInt();
            		photo = new Photo(photoNum, userID);
            		returnEmail = database.selectEmail(userID);
            	}
            	System.out.print("Old number: ");
                photoNum = intScan.nextInt();
                photo = new Photo(photoNum);
                
                System.out.print("New number: ");
                newNum = intScan.nextInt();

                returnID = database.selectUserID(photoNum);
                if (userID != returnID)
                	update.updatePhoto(userID, photoNum, newNum, photo);
                else
                	System.out.println("\nOld number is not found or New one is already exist\n");
            } else if (c == 4) {
            	System.out.print("Type: ");
                type = stringScan.nextLine();
                
                photo = new Photo(type);
                returnNums = search.search(photo);
                
                while(true)
                {
                	if (returnNums.size() != 0) {
	                	System.out.println("To Reply => 1");
	                    System.out.println("To return => 0");
	                    System.out.print(">> ");
	                    int c1 = intScan.nextInt();
	                    if(c1 == 1)
	                    {
	                    	System.out.print("Photo Number: ");
	                        photoNum = intScan.nextInt();
	                        photo = new Photo(photoNum);
	                        
	                        while (!returnNums.contains(photo.getNum())) {
	                        	System.out.println("\nNot found!\n");
	        	            	System.out.print("Enter the correct number: ");
	        	                photoNum = intScan.nextInt();
	        	                photo = new Photo(photoNum);
	                        }
	                        
	                        System.out.print("Description: ");
	                        String description = stringScan.nextLine();
	                        
	                        System.out.print("Phone Number: ");
	                        phoneNumber = intScan.nextInt();
	                        
	                        while (phoneNumber == 0 && phoneNumber.toString().length() != 11) {
		                        System.out.print("Enter valid phone number: ");
		                        phoneNumber = intScan.nextInt();
	                        }
	                        photoInf.reply(phoneNumber, photoNum, description, photo);
	                    }
	                    else if (c1 == 0)
	                    	break;
	                    else 
	                    	continue;
                	} else {
                		System.out.println("\nNO POSTS!\n");
                		break;
                	}
                }  
            } else if (c == 5) {
            	System.out.print("Your ID: ");
            	userID = intScan.nextInt();
            	photo = new Photo(photoNum, userID);
            	returnEmail = database.selectEmail(userID);
            	
            	while (!database.validateID(photo) || !email.equals(returnEmail)) {
            		System.out.println("\nInvalid ID!\n");
            		System.out.print("Enter your ID: ");
            		userID = intScan.nextInt();
            		photo = new Photo(photoNum, userID);
            		returnEmail = database.selectEmail(userID);
            	}
            	System.out.print("Photo Number: ");
                photoNum = intScan.nextInt();
                photo = new Photo(photoNum);
                                
                returnID = database.selectUserID(photoNum);
                
                if (userID == returnID) {
	            	descriptions = photoInf.viewDescription(photoNum, userID, photo);
	            	if (descriptions.size() != 0) {
		            	System.out.println();
		            	for (int i = 0; i < descriptions.size(); i++) {
		            		System.out.println(descriptions.get(i));
		            	}
		            	System.out.println();
	            	}
	            	else {
	            		System.out.println("\nNO DESCRIPTIONS!\n");
	            	}
                } else {
                	System.out.println("\nNot found!\n");
                }
            }
        }
	}

    public static void main(String[] args) {
        UserRegisteration userReg = new UserRegisteration();
        String username, email, password, conPassword, Gender; int id;
        int choise;
        
        while(true) {
            System.out.println("To SignUp => 1");
            System.out.println("To Login => 2");
            System.out.println("To Exit => 0");
            System.out.print(">> ");
            choise = intScan.nextInt();
            if (choise == 1) {
                System.out.print("Name: ");
                username = stringScan.nextLine();

                System.out.print("Email: ");
                email = stringScan.nextLine();

                System.out.print("Password: ");
                password = stringScan.nextLine();
                
                System.out.print("Confirm Password: ");
                conPassword = stringScan.nextLine();

                while (!password.equals(conPassword)) {
	                System.out.print("Enter Confirm Password again: ");
	                conPassword = stringScan.nextLine();  
                }

                System.out.print("Gender (M, F): ");
                Gender = stringScan.nextLine();

                System.out.print("ID: ");
                id = intScan.nextInt();

                User user = new User(username, email, password, conPassword, Gender, id);
                if (userReg.signUp(user))
                	HomePage(email);
            } else if (choise == 2) {
                System.out.print("Email: ");
                email = stringScan.nextLine();
                
                System.out.print("Password: ");
                password = stringScan.nextLine();
                
                if (userReg.login(email, password))
                	HomePage(email);
            } else if (choise == 0) {
            	System.out.println("Good Bye :D");
                break;
            } else {
                
            }
        }
    }
    
}
