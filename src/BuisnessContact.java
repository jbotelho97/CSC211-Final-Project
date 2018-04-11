import java.awt.*;

/**
 * This class is for business contacts. They have additional data members
 * and methods exclusive to the class.
 * @author Azlux
 *
 */
public class BuisnessContact extends Contact {
	/**
	 * An additional phone number for work separate from their personal
	 * phone number.
	 */
	private String businessPhone;
	/**
	 * This holds their occupation.
	 */
	private String job;
	/**
	 * Default constructor will call the default parent constructor along with
	 * making the business phone number 987-6543 and job a janitor.
	 */
	public BuisnessContact(){
		super();
		businessPhone = "987-6543";
		job = "janitor";
	}
	/**
	 * This will manually set up the Business Contact by calling the parent
	 * constructor for the name, phone number and age then setting up the
	 * business phone and job.
	 * @param n
	 * @param phone
	 * @param a
	 * @param workP
	 * @param j
	 */
	public BuisnessContact(String n, String phone, String a, String workP, String j){
		super(n, phone, a);
		businessPhone = workP;
		job = j;
	}
	/**
	 * Overrides the parent method and paints only the Name, Business Phone and
	 * job.
	 */
	public void paint(Graphics p, int y){
		p.setColor(Color.BLACK);
		p.drawString("Name: " + name + ", Work Number: " + businessPhone + ", Job: " + job, 60, y);
	}
}
