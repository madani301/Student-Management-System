/**
* 
*DLLTest tests the functionality of the Doubly Linked-list.
*/
package Tests;

import DAOS.IDisplayable;
import DLL.StudentList;
import Model.Student;

/**
*
* @author madani
*/

/**
*DLLTest implements IDisplayable and overrides the display method.
*A new student list is created and student objects are created.
*Then Insertion, Deletion, Searching & Display methods are applied for testing.
*/
public class DLLTest implements IDisplayable {

    @Override
    public void display() {

            StudentList SL = new StudentList();
            Student a = new Student(1, "Madani", 2, "FullTime", "19/05/1996");
            Student b = new Student(2, "Julian", 2, "PartTime", "11/10/2001");
            Student c = new Student(3, "Jeremiah", 2, "FullTime", "10/09/2003");
            Student d = new Student(4, "Angel", 2, "PartTime", "17/03/1999");
            Student e = new Student(5, "Stacy", 2, "FullTime", "13/01/1991");

            SL.insertFront(a);
            SL.insertLast(b);
            SL.insertLast(c);
            SL.insertLast(d);
            SL.insertFront(e);
            System.out.println("==================================" + "\n" + "Display List" + "\n" + "==================================");
            System.out.println(SL.toString());
            System.out.println("==================================" + "\n" + "Delete Head" + "\n" + "==================================");
            SL.deleteFirst();
            System.out.println(SL.toString());
            System.out.println("==================================" + "\n" + "Delete Tail" + "\n" + "==================================");
            SL.deleteLast();
            System.out.println(SL.toString());
            System.out.println("==================================" + "\n" + "Delete at Position (Name || ID)" + "\n" + "==================================");
            SL.deleteByName("Julian");
            System.out.println(SL.toString());
            System.out.println("==================================" + "\n" + "Print Forward" + "\n" + "==================================");
            SL.printForward();
            System.out.println("==================================" + "\n" + "Print Backward" + "\n" + "==================================");
            SL.printBackward();
            System.out.println("==================================" + "\n" + "Search by Name" + "\n" + "==================================");
            SL.searchNodebyName("Jeremiah").display();
            System.out.println("==================================" + "\n" + "Search by ID" + "\n" + "==================================");
            SL.searchNodebyID(1).display();
            System.out.println("==================================" + "\n" + "Enter Marks for Madani" + "\n" + "==================================");
            SL.addStudentMarks("Madani");
            SL.searchNodebyName("Madani").display();

    }
/**
* Entry point of the DLLTest Program.
     * @param args
*/
    public static void main(String args[]) {
            DLLTest a = new DLLTest();

            a.display();

    }
}