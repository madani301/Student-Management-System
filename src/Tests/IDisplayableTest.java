/**
*
*IDisplayableTest checks whether the interface IDisplayable has been implemented.
*/
package Tests;
import DAOS.IDisplayable;
import DAOS.IDisplayableImp;

/**
 *
 * @author madani
 */
public class IDisplayableTest {

	public static void main(String args[]) {

		IDisplayable a = new IDisplayableImp();
		a.display();

	}

}