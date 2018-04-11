import java.awt.*;
/**
 * This class holds a basic contact. Each contact has a name, phone number, and
 * age. The class has a paint method that the phone book class will use to display
 * each contact's individual info.
 * @author Azlux
 *
 */

public class Contact {
	/**
	 * This holds the contact's name.
	 */
	protected String name;
	/**
	 * This holds their personal phone number and their age.
	 */
	protected String phoneNum, age;
	/**
	 * Default Constructor sets the contact's name to John Doe
	 * their phone number to 1234567 and age to 30.
	 */
	public Contact(){
		name = "John Doe";
		phoneNum = "123-4567";
		age = "30";
	}
	/**
	 * This will allow for the manual set-up of the contacts. 
	 * @param n - will be name
	 * @param phone - will be phone number
	 * @param a - will be Age
	 */
	public Contact(String n, String phone, String a){
		name = n;
		phoneNum = phone;
		age = a;
	}
	/**
	 * Returns the name of the contact. 
	 * @return
	 */
	public String getName(){
		return name;
	}
	/**
	 * Returns the phone number. This will be used when the user is searching for
	 * a phone number based off the name.
	 * @return
	 */
	public String getPhone(){
		return phoneNum;
	}
	/**
	 * Returns true if the other Contact's name comes before the current one
	 * alphabetically. This will be used to sort the Contacts in their array. 
	 * @param o - the other object
	 * @return 
	 */
	public boolean alphabetize(Contact o, int startIndex){
		String otherName = o.getName();
		otherName = otherName.toUpperCase();
		String newName = name.toUpperCase();
		char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
				'Y', 'Z'};
		int indexA = 0; //The index for the current object
		int indexB = 0; // The index for the other object (the parameter).
		for(int i = 0; i < alphabet.length; i++){
			if(newName.charAt(startIndex) == alphabet[i]){
				indexA = i;
			}
			if(otherName.charAt(startIndex) == alphabet[i]){
				indexB = i;
			}
		}
		if(indexA > indexB){
			return true;
		}
		else if(indexB > indexA){
			return false;
		}
		else{
			/**
			 * This will alphabetize them based on the next letter if they both start
			 * with the same first letter.
			 */
			if(startIndex + 1 < name.length() && startIndex + 1 < otherName.length())
				return alphabetize(o, startIndex + 1);
			else
				return true;
		}

	}
	/**
	 * Paints the contact info on the Phone Book.
	 * @param p
	 */
	public void paint(Graphics p, int y){
		p.setColor(Color.BLACK);
		p.drawString("Name: " + name + ", Phone Number: " + phoneNum + ", Age : " + age, 60, y);
	}
}
