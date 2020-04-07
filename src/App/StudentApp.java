/**
 * 
*StudentApp contains the main method and is where the program starts.
*/
package App;

import Controllers.StudentController;

/**
* @madani
*/
public class StudentApp {

/**
*The method run() is called from the main method to launch StudentController,
*which is the class that contains the code to handle the menu, hence the program.
*/
	public static void run() {
		System.out.println("Welcome to the Student Management App!");

		StudentController studentController = new StudentController();

		studentController.run();

		System.out.println("Your data was saved.\nThank you for using Student Management App. Good bye.\n");
	}

/**
* Entry point of the program.
* Runs the entire program
* @param args the command line arguments
*/
	public static void main(String[] args) {
		StudentApp studentApp = new StudentApp();
		StudentApp.run();
	}
}