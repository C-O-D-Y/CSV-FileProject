package Choose;

import java.util.Scanner;

import Show_Option.FileExitence;

/*
 * This Class takes a Login to from the user to give access to Authorized person Only
 */

public class Login {
	private static String Username = "cody";
	private static String Password = "saurabh";
	/*
	 * Method takes Input from the user and check the credentials if they are
	 * matching or not and redirect accordingly
	 */

	public static void main(String[] args) {
		try {
			while (1 > 0) {
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the username[Case Sensitive]");
				String username = scanner.nextLine();
				System.out.println("Enter the Password[Case Sensitive]");
				String password = scanner.nextLine();
				if (Username.equals(username) && Password.equals(password)) {
					System.out.println("\n Welcome to Employer Management services\n");
					// After successful login calling User_Options class from package
					// 'com.EmployeeManager.ShowOptions'
					new FileExitence().call();
					break;
				} else {
					System.out.println("Wrong credentials");
				}
			}
		} catch (NullPointerException e) {
			System.out.println("UserName or Password cannot be Empty");
		}
	}

}
