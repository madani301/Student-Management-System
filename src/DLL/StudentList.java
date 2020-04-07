/**
 * 
*StudentList creates the doubly linked-list for Students.
*It contains the logic of the program for Insertion, Deletion, Searching & Displaying Students. 
*/
package DLL;

import DAOS.DAOO;
import Model.Student;
import DAOS.IDisplayable;
import Node.ListNode;
import java.io.Serializable;

/**
* @author madani
*/
public class StudentList implements IDisplayable,
Serializable {

	private ListNode head;
	private ListNode tail;
	private int length;

/**
*Sets the head & tail to null before creating the list.
*Sets the length to 0 because it does not contain any students.
*/
	public StudentList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}

/**
* @return Count the number of students (Nodes) in the list.
*/
	public int countNodes() {
		int counter = 0;
		ListNode current = head;

		while (current != null) {
			counter++;
			current = current.next;
		}
		return counter;
	}

/**
* @return Check if the list is empty.
*/
	public boolean isEmpty() {
		return head == null;
	}

/**
*
* @return Check the size of the list.
*/
	public int length() {
		if (isEmpty()) {}
		return length;
	}

/**
* CONDITION: Check if the list is empty, if yes, the head & tail becomes the node.
* Else, Add student (node) at the tail of the list by traversing the list. 
* @param student is the node to be added at the tail.
*/
	public void insertLast(Student student) {
		ListNode newNode = new ListNode(student);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
			tail.next = null;
		}
		length++;
	}

/**
* Add marks to specific student in the list.
* @param name is the identifier for the student who's grades are being added.
*/
	public void addStudentMarks(String name) {
		try{
                    ListNode node = searchNodebyName(name);
                    node.getStudent().setMarks();
                }catch(Exception e){
                        System.out.println("Student Name " + name + " does not exist.");
                        }

	}

/**
* Search for a student by Student ID.
* @param value is the Student ID that we are looking for.
* @return 
*/
	public ListNode searchNodebyID(int value) {
		int i = 0;

		ListNode newNode = head;
		if (head == null) {
			System.out.println("List is empty");
			return null;
		}
		while (newNode != null) {
			if (newNode.getStudent().getStudentID() == value) {
				return newNode;
			}
			newNode = newNode.next;
			i++;
		}
		return null;
	}

/**
* Search for student by Student Name
* @param value is the Student Name we are looking for. 
* @return
*/
	public ListNode searchNodebyName(String value) {
		int i = 0;

		ListNode newNode = head;
		if (head == null) {
			System.out.println("List is empty");
			return null;
		}
		while (newNode != null) {
			if (newNode.getStudent().getStudentName().equals(value)) {
				return newNode;
			}
			newNode = newNode.next;
			i++;
		}
		return null;
	}

/**
* CONDITION: Check if the list empty, if yes, then throw exception.
* Delete the first node in the list; the head.
*/
	public void deleteFirst() {
		if (head == null) {
			throw new RuntimeException("List is empty");
		}
		if (head.next == null) {
			tail = null;
		} else {
			head.next.previous = null;
		}
		head = head.next;
		length--;
	}

/**
* CONDITION: Check if the list empty, if yes, then throw exception.
* Delete the last node in the list; tail
*/
	public void deleteLast() {
		if (tail == null) {
			throw new RuntimeException("List is empty");
		}
		if (head.next == null) {
			head = null;
		} else {
			tail.previous.next = null;
		}
		tail = tail.previous;
		length--;
	}

/**
* Important: Can delete Student at any position in the doubly linked-list given the Student ID.
* This method gets an int value ID of student to be deleted from the list.
* @param value is the Student ID entered by the user.
*/
	public void deleteByID(int value) {
		if (isEmpty()) {
			System.out.println("List is Empty. Can't delete " + value);
			return;
		} else {

			ListNode newNode = head;
			while (newNode != null) {
				if (newNode.getStudent().getStudentID() == value) {
					if (newNode == head) {
						System.out.println(value + " deleted.");
						deleteFirst();
						return;

					} else if (newNode == tail) {
						System.out.println(value + " deleted.");
						deleteLast();
						return;
					} else {
						System.out.println(value + " deleted.");
						newNode.next.previous = newNode.previous;
						newNode.previous.next = newNode.next;
						newNode = null;
					}
					length--;
					return;
				}
				newNode = newNode.next;
			}
		}
		System.out.println("List does not contain Student ID " + value);
	}

/**
* Important: Can delete Student at any position in the doubly linked-list given the Student Name.
* This method gets a String value (name) of student to be deleted from the list.
* @param value is the Student Name entered by the user.
*/
	public void deleteByName(String value) {
		if (isEmpty()) {
			System.out.println("List is Empty. Can't delete " + value);
			return;

		} else {
			ListNode newNode = head;

			while (newNode != null) {
				if (newNode.getStudent().getStudentName().equals(value)) {
					if (newNode == head) {
						System.out.println(value + " deleted.");
						deleteFirst();
						return;

					} else if (newNode == tail) {
						System.out.println(value + " deleted.");
						deleteLast();
						return;

					} else {
						System.out.println(value + " deleted.");
						newNode.next.previous = newNode.previous;
						newNode.previous.next = newNode.next;
						newNode = null;
					}
					length--;
					return;
				}
				newNode = newNode.next;
			}
		}
		System.out.println("List does not contain Student Name " + value);
	}

/**
* saveStudentList(StudentList studentList).
* Given a list, the method saves it to the external file (studentList.bin).
* @param studentList A doubly linked-list of Students.
*/
	public void saveStudentList(StudentList studentList) {
		DAOO daoo = new DAOO(); //an instance of DAOO which has saveList method for saving to a file
		daoo.saveList(studentList); //an instance of DAOO which has readList method for reading from a file
	}

/**
* readStudentList()
* @return StudentList object read from a file or Null if object not found.
*/
	public StudentList readStudentList() {
		DAOO daoo = new DAOO();
		return daoo.readList();
	}

/**
* Student list representation with full student details.
* Node: call toString() for a simplified version of the display.
*/
	@Override
	public void display() {
		ListNode node = head;
		while (node != null) { //keep going until there is no more
			node.display();
			node = node.next;
		}
	}

/**
* Student list representation that does not show the student details.
* @return String representation of the student list.
* Node: Call display() for a full version of the display.
*/
	@Override
	public String toString() {
		String studentList = "Students: \n";
		ListNode node = this.head;
		while (node != null) {
			studentList += node;
			//prevents this symbol ">>" from being printed at the end,
			//signaling next, when indeed there is nothing to show.
			if (node.next != null) {
				studentList += " >> ";
			}
			node = node.next;
		}
		return studentList;
	}

/**
*******************************************************************************************************
* THE METHODS BELOW ARE FOR DEMONSTRATING FRONT & BACKWARDS INSERTIONS PLUS FRONT & BACKWARDS PRINTING.
*******************************************************************************************************
*/

/**
 * CONDITION: Check if the list is empty first.
 * This method inserts a node at the start of the list and make that node the new head.
 * @param student
 */

	public void insertFront(Student student) {
		ListNode newNode = new ListNode(student);

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		}

		else {

			head.previous = newNode;

			newNode.next = head;

			head = newNode;

		}

		length++;
		System.out.println(student.toString() + " added to front");

	}

/**
* This method prints the list from head to tail.
*/
	public void printForward() {
		if (isEmpty()) {
			System.out.println("The list is empty/");
		}
		else {
			ListNode newNode = head;

			System.out.print("Forward List: ");
			while (newNode != null) {
				System.out.print(newNode.getStudent());
				System.out.print(" >> ");

				newNode = newNode.next;
			}
			System.out.println("Null");
		}
	}

/**
* This method print the list from tail to head. 
*/
	public void printBackward() {
		if (isEmpty()) {
			System.out.println("List is Empty");
		}
		else {
			ListNode newNode = tail;

			System.out.print("Backward List: ");
			while (newNode != null) {
				System.out.print(newNode.getStudent());
				System.out.print(" >> ");

				newNode = newNode.previous;
			}
			System.out.println("Null");
		}
	}   
}