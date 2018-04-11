import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class will hold 10 contacts which will each have a phone number,
 * name and other info depending on the contact type. 
 * The class will be able to sort the contacts by each of these identifiers. 
 * The user will enter the information about each of the contacts as the program
 * starts.
 * @author Azlux
 *
 */
public class PhoneBook extends Frame implements MouseListener, ActionListener {
	/**
	 * This is the array of contacts that the phone book will use.
	 */
	Contact[] contacts;
	
	private UneFenetre myWindow;
	
	private int contactsIndex = 0;

	/**
	 * Each of these buttons will allow the user to sort the list of contacts.
	 */
	private Button searchName, sortName, exitButton, addButton, addBuisness;
	
	/**
	 * This will initialize the phone book window and set up the array of contacts.
	 */
	public PhoneBook(){
		initialize();
		myWindow = new UneFenetre();//to allow for window closing
		addWindowListener(myWindow);
		addMouseListener(this);
		searchName = new Button("Search", Color.RED, 100, 650, 100, 50);
		sortName = new Button("Sort", Color.RED, 250, 650, 100, 50);
		addButton = new Button("Add Regular", Color.RED, 375, 650, 150, 50);
		addBuisness = new Button("Add Buisness", Color.RED, 550, 650, 150, 50);
		exitButton = new Button("Exit", Color.WHITE, 725, 650, 100, 50);
		contacts = new Contact[10];
	}
	
	/**
	 * This will set up the window and the contact array and buttons.
	 */
	private void initialize(){
		setSize(1000,750);
		setTitle("Your Phonebook!");
		setVisible(true);
		setBackground(Color.GREEN);
	}
	/**
	 * This will add a regular contact to the phone book.
	 */
	public void addRegularContact(){
		String name = JOptionPane.showInputDialog(null, "Enter a name: ", "Creating New Contact", JOptionPane.QUESTION_MESSAGE);
		String phone = JOptionPane.showInputDialog(null, "Enter a phone number: ", "Creating New Contact", JOptionPane.QUESTION_MESSAGE);
		String age = JOptionPane.showInputDialog(null, "Enter an age: ", "Creating New Contact", JOptionPane.QUESTION_MESSAGE);
		if(name != null && phone != null && age != null){//Makes sure every data member is filled.
		contacts[contactsIndex] = new Contact(name, phone, age);
		contactsIndex ++;
		}
		else
			JOptionPane.showMessageDialog(null, "No contact created!");
		repaint();
	
	}
	/**
	 * This adds a business contact to the phone book.
	 */
	public void addBuisnessContact(){
		String name = JOptionPane.showInputDialog(null, "Enter a name: ", "Creating New Contact", JOptionPane.QUESTION_MESSAGE);
		String phone = JOptionPane.showInputDialog(null, "Enter a phone number: ", "Creating New Contact", JOptionPane.QUESTION_MESSAGE);
		String age = JOptionPane.showInputDialog(null, "Enter an age: ", "Creating New Contact", JOptionPane.QUESTION_MESSAGE);
		String businessPhone = JOptionPane.showInputDialog(null, "Enter a work phone number: ", "Creating New Contact", JOptionPane.QUESTION_MESSAGE);
		String job = JOptionPane.showInputDialog(null, "Enter a job: ", "Creating New Contact", JOptionPane.QUESTION_MESSAGE);
		if(name != null && phone != null && age != null && businessPhone != null && job != null){
			contacts[contactsIndex] = new BuisnessContact(name, phone, age, businessPhone, job);
			contactsIndex ++;
		}
		else{
			JOptionPane.showMessageDialog(null, "No contact created!");
		}
		repaint();
	
	}
	/**
	 * This will open up a box for the user to input text.
	 */
	public void askForSearch(){
		String name = JOptionPane.showInputDialog(null, "Enter a name: ", "Searching for phone", JOptionPane.QUESTION_MESSAGE);
		int index = -1;
		for(int i = 0; i < contactsIndex; i++){	
			if(name.equals(contacts[i].getName())){
					index = i;
				}
		}
		if(index != -1)
			JOptionPane.showMessageDialog(null, "The personal phone number of " + name + " is " + contacts[index].getPhone() + ".");
		else
			JOptionPane.showMessageDialog(null, "Name not found!");
	}
	/**
	 * This sorts the names alphabetically by first name.
	 */
	public void sort(){
		for(int i = 1; i < contactsIndex; i++){
			boolean done = false;
			for(int j = i; j > 0 && !done; j--){
				if(contacts[j].alphabetize(contacts[j - 1], 0) == false){
					Contact temp = contacts[j];
					contacts[j] = contacts[j - 1];
					contacts[j - 1] = temp;
				}
				else
					done = true;
			}
		}
		repaint();
	}

	public void paint(Graphics p){
		searchName.paint(p);
		sortName.paint(p);
		addButton.paint(p);
		addBuisness.paint(p);
		exitButton.paint(p);
		p.setColor(Color.WHITE);
		p.fillRect(50, 50, 900, 500);
		int y = 60;
		for(int i = 0; i < contacts.length; i++){
			if(contacts[i] != null)
				contacts[i].paint(p, y);
			y += 15;
		}
	}
	
	/**
	 * This will check to see if a button was pressed when the mouse was clicked.
	 * If it is, it will do the command which the individual button is desinged
	 * to do.
	 */
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(addButton.isInside(x, y)){
			if(contactsIndex < 10)
				addRegularContact();
			else
				JOptionPane.showMessageDialog(null, "Max number of contacts reached");
		}
		if(addBuisness.isInside(x,  y)){
			if(contactsIndex < 10)	
				addBuisnessContact();
			else
				JOptionPane.showMessageDialog(null, "Max number of contacts reached");
		}
		if(exitButton.isInside(x, y)){
			System.exit(0);
		}
		if(searchName.isInside(x,  y)){
			if(contacts.length > 0)
				askForSearch();
			else
				JOptionPane.showMessageDialog(null, "Add contacts first.");
		}
		if(sortName.isInside(x,  y)){
			if(contacts.length > 1)
				sort();
			else
				JOptionPane.showMessageDialog(null, "Add two contacts first.");
		}

		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
