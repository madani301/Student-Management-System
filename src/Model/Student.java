/**
*
*Student contains the data for a student, such as studentID, studentName, etc. 
*It contains the getters and setters for the private variables. 
*/
package Model;

import Helpers.InputHelper;
import DAOS.IDisplayable;
import java.io.Serializable;
import java.util.ArrayList;

/**
*
* @author madani
* @param <Category>
*/
public class Student < Category > implements IDisplayable,
Serializable {

	private int studentID;
	private String studentName;
	private int numOfSubjects;
	private ArrayList < Subject > marksForEachSubject = new ArrayList < >();
	private String enrolmentDate;
	private Category studentCategory;

/**
*
* @param studentID
* @param studentName
* @param numOfSubjects
* @param enrolmentDate
* @param studentCategory
*/
	public Student(int studentID, String studentName, int numOfSubjects, String enrolmentDate, Category studentCategory) {

		this.studentID = studentID;
		this.studentName = studentName;
		this.numOfSubjects = numOfSubjects;
		this.enrolmentDate = enrolmentDate;
		this.studentCategory = studentCategory;

	}

/**
*Student constructor.
*/
	public Student() {

}

/**
*
* @return
*/
	public int getStudentID() {
		return studentID;
	}

/**
*
* @param sID
*/
	public void setStudentID(int sID) {
		this.studentID = sID;
	}

/**
*
* @return
*/
	public String getStudentName() {
		return studentName;
	}

/**
*
* @param studentName
*/
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

/**
*
* @return
*/
	public int getNumOfSubjects() {
		return numOfSubjects;
	}

/**
*
* @param numOfSubjects
*/
	public void setNumOfSubjects(int numOfSubjects) {
		this.numOfSubjects = numOfSubjects;
	}

/**
*Sets the marks for a specific student.
*Uses a counter to keep track of number of subjects,
*then asks for the same amount of marks for each subjects.
*/
	public void setMarks() {
		InputHelper inputHelper = new InputHelper();
		int counter = 1;
		if (this.marksForEachSubject.size() >= getNumOfSubjects()) { //check if mark has been asigned already
			System.out.println("Student already has marks");
		} else {
			for (int i = 0; i < getNumOfSubjects(); i++) {
				String subjectName = inputHelper.readStringOnly("Enter subject " + counter + " name");
				int subjectMark = inputHelper.readInt("Enter subject mark");
				Subject subject = new Subject(subjectName, subjectMark);
				this.marksForEachSubject.add(subject);
				counter++;
			}
			System.out.print("Information added\n");
		}

	}

/**
*Gets the average marks for each student.
* @return
*/
	public double getAverage() {
		double average = 0f;
		for (Subject marks: marksForEachSubject) {
			average += marks.getMark();
		}
		return (average / getNumOfSubjects());
	}

/**

* @param subjectName
* @return
*/
	public int getMarkForASubject(String subjectName) {
		return marksForEachSubject.indexOf(subjectName);
	}

/**
*
* @return
*/
	public String getMarksForEachSubject() {
		String marksForEachSubject = "";
		for (Subject subject: this.marksForEachSubject) {
			marksForEachSubject += subject;
		}
		return marksForEachSubject;
	}

/**
*
* @return
*/
	public String getStudentCategory() {
		return (String) studentCategory;
	}

/**
*
* @param studentCategory
*/
	public void setStudentCategory(Category studentCategory) {
		this.studentCategory = studentCategory;
	}

/**
*
* @return
*/
	public String getEnrolmentDate() {
		return enrolmentDate;
	}

/**
*
* @param enrolmentDate
*/
	public void setEnrolmentDate(String enrolmentDate) {
		this.enrolmentDate = enrolmentDate;
	}

	@Override
	public String toString() {
		return this.studentName;
	}

/**
*Displays the StudentList with all details.
*/
	@Override
	public void display() {
		System.out.printf("%s\n" + "%-30s %s\n" + "%-30s %s\n" + "%-30s %d\n" + "%-30s %s\n" + "%-30s %s\n" + "%-30s %s\n",

		getStudentName() + " Details: " + "\n", "     ID:", getStudentID(), "     Name:", getStudentName(), "     Number of Subjects:", getNumOfSubjects(), "     Marks for each Subject:\n\n", getMarksForEachSubject(), "     Category:", getStudentCategory(), "     Average Marks:", getAverage(), "     Date of Enrolment:", getEnrolmentDate());

		System.out.println("***********************************************************");
	}

}