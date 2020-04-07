/**
 * 
*Subject handles the marks for each specific subject of a student. 
*/
package Model;

import java.io.Serializable;

/**
* @madani
*/

public class Subject implements Serializable { //objects of type subject can be saved
	private final String studentName;
	private int mark;
	private int average;

/**
* Subject(String name, int mark)
* Constructor for creating objects of type Subject given a String name and int mark
* @param name name of the subject
* @param mark mark of the subject
*/
	public Subject(String name, int mark) {
		this.studentName = name;
		this.mark = mark;
	}

/**
* getName()
* Method returns the name of the current subject
* @return name
*/
	public String getName() {
		return this.studentName;
	}

/**
* setMark(int mark)
* Given an int mark, the method sets the mark for the current student
* @param mark of the current subject
*/
	public void setMark(int mark) {
		this.mark = mark;
	}

/**
* getMark()
* Method returns the an int, value of the current mark
* @return name
*/
	public int getMark() {
		return this.mark;
	}

/**
* toString()
* @return String representation of the subject
*/
	@Override
	public String toString() {
		return String.format("\t          %-30s%d\n", getName() + ":", getMark());
	}

}