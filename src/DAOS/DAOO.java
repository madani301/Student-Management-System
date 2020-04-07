/**
 * 
*DAOO handles reading data from the BIN file and writing to the BIN file.
*/
package DAOS;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import DLL.StudentList;

/**
* @madani 
*/
public class DAOO {

/**
* Saves the student list to external file as a serializable object.
* @param studentList list to be saved to external file.
*/
	public void saveList(StudentList studentList) {
		ObjectOutputStream sutudentOutputStream = null;
		try {

			sutudentOutputStream = new ObjectOutputStream(new FileOutputStream("studentList.bin"));
		} catch(FileNotFoundException ex) {
			Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
		} catch(IOException ex) {
			Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			sutudentOutputStream.writeObject(studentList);
		} catch(IOException ex) {
			Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				sutudentOutputStream.close();
			} catch(IOException ex) {
				Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	}

/**
* Reads a student list object from a file.
* @return deserialized student list object.
*/
	public StudentList readList() {
		File file = new File("studentList.bin");
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream("studentList.bin"));
		} catch(EOFException ex) {} catch(FileNotFoundException ex) {
			Logger.getLogger(DAOO.class.getName()).log(Level.SEVERE, null, ex);
		} catch(IOException ex) {
			Logger.getLogger(DAOO.class.getName()).log(Level.SEVERE, null, ex);
		}

		StudentList studentList = new StudentList();
		try {

			if (file.length() == 0) return null;
			else studentList = (StudentList) objectInputStream.readObject();
		} catch(IOException | ClassNotFoundException ex) {
			Logger.getLogger(DAOO.class.getName()).log(Level.SEVERE, null, ex);
		}

		try {
			objectInputStream.close();
		} catch(IOException ex) {
			Logger.getLogger(DAOO.class.getName()).log(Level.SEVERE, null, ex);
		}

		return studentList;
	}
}