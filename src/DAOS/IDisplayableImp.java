/**
*
IDisplayableImp is the class which implements IDisplayable.
*/
package DAOS;

import Model.Student;

/**
 *
 * @author madani
 */
public class IDisplayableImp implements IDisplayable {

/**
*The method display() is overridden here to be implemented.
*/
	@Override
	public void display() {
		System.out.print("IDisplayable implemented.");
		System.out.println("\n***---***---***---***");

		Student student = new Student(1, "Madani", 2, "FullTime", "19/05/1996");
		student.setMarks();
		student.display();
	}
}