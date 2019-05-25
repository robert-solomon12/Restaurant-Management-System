
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;



public class WelcomeMenuController implements Serializable {
	
	private static Scanner input= new Scanner(System.in);
	
	//private Booking booking;
	public Table headTable=null;
	
	private int tableNum=0;
    private Booking firstBooking=null;
    private int bookingNum=0;
    private FoodDrinkMenu firstFdItem=null;
    private int fdMenuNum=0;
	private Purchase firstPurchase = null;
    //private int number=1;
    //private Purchase firstPurchase = null; //NO....
    private int purchase=0;

	private FoodDrinkMenu fdm;
 
    
  /*
   implements Serializable
   
   
   File
   FileOutputStream / FileInputStream
   ObjectOutputStream / ObjectInputStream
   writeObject() / readObject()
   
   
   */
	
	public static void main(String[] args) {

		
		//WelcomeMenuController app;
		WelcomeMenuController app = new WelcomeMenuController();
		app.runMenu();
		
		try {
			app = WelcomeMenuController.load();
			app.runMenu();
			
		} catch (Exception e) {
			app = new WelcomeMenuController();
			app.runMenu();
		}
		
		//app.initForTesting(); //for testing only
		
		
		
		/*
		 ObjectOutputStream / ObjectInputStream
		 writeObject() / readObject();
		  
		  
		 */
	}

	
	/*public void initForTesting() {
		addNewFoodAndDrinkItem("Pizza",4.99);
		addNewFoodAndDrinkItem("Salad",2.49);
		addNewFoodAndDrinkItem("EggDish",3.99);
	}*/
	
	
	/**
	 * mainMenu() - This method displays the menu for the application, reads the
	 * menu option that the user entered and returns it.
	 * 
	 * @return the users menu choice
	 */
	private int mainMenu() {
		System.out.println("Table Menu");
		System.out.println("---------");
		System.out.println("  1) Add a Table");
		System.out.println("  2) View Table");
		//System.out.println("  3) Delete Table");
		System.out.println("---------");
		System.out.println("Booking Menu");
		System.out.println("---------");
		System.out.println("  4) Add a Booking");
		System.out.println("  5) View Booking");
		System.out.println("  6) Delete Booking");
		System.out.println("---------");
		System.out.println("  7) Add New Food/Drink Order");
		System.out.println("  8) View Food/Drink ordered");
		System.out.println("  9) Delete Food/Drink ordered");
		System.out.println("---------");
		System.out.println("Purchase Menu");
		System.out.println("---------");
		System.out.println("  10) Add a Purchase");
	    System.out.println("  11) View All Purchases");
	    System.out.println("  12) Delete Purchase");
	    System.out.println("  13) View All Tables & Bookings");
	    System.out.println("  14) Save to XML");
	    System.out.println("  15) Reset");
	    System.out.println(" 16) Check Out!");
		System.out.println("-----------");
		System.out.println("-----------");
		System.out.println("  0) Exit");
		System.out.print("==>> ");
		int option = input.nextInt();
		return option;
	}

	/**
	 * This is the method that controls the loop of the Menu.
	 */
	private void runMenu() {
		int option = mainMenu();
		while (option != 0) {

			switch (option) {
			case 1:
				addTable();
				break;
			case 2:
				viewTables();
				break;
			/*case 3:
				input.nextLine();
				deleteTable(promptForInt("Enter Table Number to delete"));
				break;*/
			case 4 :
				addBooking();
				break;
			case 5:
				viewBookings();
				break;
			case 6:
				input.nextLine();
				deleteBookings(promptForString("Enter Customer Name to delete"));
				break;
			case 7:
				addNewFoodAndDrinkItem();
				break;
			case 8:
				viewFoodItems();
				break;
			case 9:
				input.nextLine();
				deleteFoodItems(promptForString("Enter item to delete"));
				break;
			case 10:
				addPurchase();
				break;
			case 11:
				viewAllPurchases();
				break;
			case 12: 
				input.nextLine();
				deletePurchases(promptForString("Enter Item Purchased to delete"), firstBooking);
				break;
			case 13:
				viewAllTablesAndBookings();
				break;
			case 14:
				try {
					save(this);
				} catch (Exception e) {
					System.out.println("Error writing to file: " + e);
				}
				break;
			case 15:
				reset();
				break;
//			case 16:
//				input.nextLine();
//				checkOut();
//				break;
			case 17:
				try {
					load();
				} catch (Exception e) {
					System.out.print("Error reading from file: " + e);
				}
				break;
			
				
			default:
				System.out.println("Invalid option entered: " + option);
				break;
			}
			
			// pause the program so that the user can read what we just printed to the
			// terminal window
			System.out.println("\nPress any key to continue...");
			input.nextLine();
			input.nextLine(); // this second read is required - bug in Scanner class; a String read is ignored
								// straight after reading an int.

			// display the main menu again
			option = mainMenu();
		}

		// the user chose option 0, so exit the program
		System.out.println("Exiting... bye");
		System.exit(0);
	}
	
	//Prompts the user to enter String in order to call the method relevant to delete based on the String entered
	public String promptForString(String prompt) {
		System.out.print(prompt+": ");
		return input.nextLine();
	}
	
	
	
	/*
	 * SAVE METHOD FOR THE ENTIRE SYSTEM
	 */
	
	public static void save(WelcomeMenuController app) throws Exception {
		try {
		XStream xstream = new XStream(new DomDriver());
	ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("WelcomeMenuBookings.xml"));
	out.writeObject(app);
	out.close();
		}catch(Exception e) {
			System.out.println("Save error "+e.getMessage());
		}
	}
	
	
	/*
	 * SAVE METHOD FOR THE ENTIRE SYSTEM
	 */
	@SuppressWarnings("unchecked")
	public static WelcomeMenuController load() throws Exception {
		XStream xstream = new XStream(new DomDriver());
		ObjectInputStream is = xstream.createObjectInputStream(new FileReader("WelcomeMenuBookings.xml"));

		WelcomeMenuController app=(WelcomeMenuController)is.readObject();
		
		is.close();
		return app;
	}

	
	/*
	 * METHOD TO ADD TABLES
	 */
		public void addTable() {
			System.out.print("Please Enter the number of seats: ");
			int numberOfSeats = input.nextInt();
		
			tableNum++;
			Table nt=new Table(tableNum,numberOfSeats);
			
			nt.next=headTable;
			headTable=nt;			
		}

		/*
		 * METHOD TO VIEW TABLES ADDED
		 */
		public void viewTables() {
			Table temp=headTable;
			System.out.print("Table Details"+" \n ");
			while(temp!=null){
				System.out.print("\t"+"Table No. "+temp.getTableNumber()+", Seats "+temp.getNumberOfSeats()+ " \n ");
				temp=temp.next;
			}
		}
		
		
		
		 /*
		  * METHOD TO DELETE A TABLE
		  */
		
		 /*
		 public void deleteTable(int number) {
			Table temp3=headTable,temp4=null;
			
			while(temp3!=null && !temp3. .equals(number)) { 
				temp4=temp3;
				temp3 = temp3.next;
			}
			
			if(temp3!=null) { //found it
			
				if(temp4!=null) temp4.next=temp3.next; //not at the head
				else headTable=headTable.next; //delete the head
				System.out.println("Table Number "+number+" deleted.");
			}
			else {//not found
				System.out.println("Table Number "+number+" not found.");
			} 

			}
			*/
		
		/*
		 * METHOD TO ADD BOOKINGS 
		 */
		 public void addBooking() {
			System.out.print("Please Enter your Name: ");
			String customerName = input.nextLine();
			customerName = input.nextLine();
			System.out.print("Number of People booking: ");
			int numberOfPplBooking= input.nextInt();
			System.out.print("Table Number being booked: ");
			int tableNumberBooked = input.nextInt();
			System.out.print("Time of Booking: ");
			int bookingTime = input.nextInt();
			System.out.print("The Amount of time (in hours) the booking is for: ");
			int amountOfTimeBooking = input.nextInt();
			
			bookingNum++;
			Booking nb=new Booking(bookingNum,customerName,numberOfPplBooking,tableNumberBooked,bookingTime,amountOfTimeBooking);
			
			nb.next=firstBooking;
			firstBooking=nb;
		 }

			 public void viewBookings() {
					Booking temp2=firstBooking;
					System.out.println("Booking Details:"+" \n ");
					while(temp2!=null){
						//process Booking here....
						System.out.println("Booking Details: "+" \n " + 
						"\t"+"Booking No.: "+temp2.getbookingNumber() +" \n " +
						"\t" + "Customer Name: "+temp2.getCustomerName()+" \n " +
						"\t" + "Number of People Booking: "+temp2.getNumberOfPplBooking()+" \n " +
						"\t" + "Table Number Booked: "+temp2.getTableNumberBooked()+" \n " +
						"\t" + "Booking Time: "+temp2.getBookingTime()+" \n " +
						"\t" + "The Amount of time (in hours) the booking is for: "+temp2.getAmountOfTimeBooking());
			 			temp2=temp2.next;
					}
			}
			 
			 /*
			  * METHOD TO DELETE BOOKING
			  */
			 public void deleteBookings(String name) {
					Booking temp3=firstBooking,temp4=null;
					
					
					
					while(temp3!=null && !temp3.customerName.equals(name)) { 
						temp4=temp3;
						temp3 = temp3.next;
					}
					
					if(temp3!=null) { //found it
					
						if(temp4!=null) temp4.next=temp3.next; //not at the head
						else firstBooking=firstBooking.next; //delete the head
						System.out.println("Item "+name+" deleted.");
					}
					else {//not found
						System.out.println("Item "+name+" not found.");
					} 

					}
			
/*
 * !!! HERE I WILL CREATE MY SEARCH ALGORITHM!!!
 * 
 * 
 * /*
			public void SEARCH(int index) {
				if (!(index > (numberOfMembers() - 1) || index < 0))
					members.remove(index);
			}
			*/
			 
			/*
			 * METHOD TO ADD FOOD/DRINK ADDED
			 */
			public void addNewFoodAndDrinkItem() {	
				
				System.out.print("Please Enter Food/Drink Item: "+ " \n ");
				String fdMenuItem = input.nextLine();
				fdMenuItem = input.nextLine();
				System.out.print("Please Enter Price: "+ " \n ");
				double itemPrice= input.nextInt();
				addNewFoodAndDrinkItem(fdMenuItem,itemPrice);
			}
	
			
			//Method for number iterating through the foodMenu when a food has been added!
			public void addNewFoodAndDrinkItem(String fdMenuItem, double itemPrice) {	
				fdMenuNum++;
				FoodDrinkMenu nf=new FoodDrinkMenu(fdMenuNum,fdMenuItem,itemPrice);
					
				//head insertion
				//nf.next=firstFdItem;
				//firstFdItem=nf;
				
				//tail insertion
				if(firstFdItem!=null) {
					fdm = firstFdItem; 
					while(fdm.next!=null) fdm=fdm.next;
					fdm.next=nf;
				}
				else firstFdItem=nf;
				
			}
			
			/*
			 * METHOD TO VIEW FOOD/DRINK ADDED
			 */
			
			public void viewFoodItems() {
				// int number=1;
				fdm = firstFdItem; 
				System.out.println("FoodDrink Item Details: \n========================\n");
				while(fdm!=null){
					
					System.out.println("Number: "+ fdm.getFoodMenuNumber() +""+" \n " +
							"\t" + "Item Name: "+fdm.getFdMenuItem()+" \n " +
							"\t" + "Item Cost Cost.: "+fdm.getItemPrice());
					
					fdm=fdm.next;
					//number++;
				}	
	
		}
			
			/*
			 * METHOD TO DELETE A FOOD/DRINK
			 */
			
			public void deleteFoodItems(String item) {
				FoodDrinkMenu temp1=firstFdItem,temp2=null;
				
				while(temp1!=null && !temp1.getFdMenuItem().equals(item)) { 
					temp2=temp1;
					temp1 = temp1.next;
				}
				
				if(temp1!=null) { //found it
				
					if(temp2!=null) temp2.next=temp1.next; //not at the head
					else firstFdItem=firstFdItem.next; //delete the head
					System.out.println("Item "+item+" deleted.");
				}
				else {//not found
					System.out.println("Item "+item+" not found.");
				} 

				}	
			
			
			
			/*
			 * METHOD TO ADD PURCHASE
			 */
			public void addPurchase() {
				//System.out.print("Please Enter your Name: ");
				System.out.print("Enter Booking Id for Purchase: ");
				int bid = input.nextInt();
				
				//Find booking to add purchase to
				Booking thebooking=firstBooking;
				
				
				if(thebooking==null){
					System.out.println("No Bookings Found!"); //no booking found....
					return; 
					}
				else{ 
					while(thebooking.getbookingNumber()!=bid) thebooking=thebooking.next;
				}
				
				System.out.print("Menu Item being purchased: ");
				String itemPurchased = input.nextLine();
				itemPurchased = input.nextLine();
				System.out.print("Quantities of Purchase: ");
				int quantity= input.nextInt();
				
				purchase++;
				Purchase np=new Purchase(purchase,itemPurchased,quantity);
				
				//head insertion
				np.next=thebooking.firstPurchase;
				thebooking.firstPurchase=np;
			 }
			
			
			/**
			 * METHOD TO VIEW ADD VIEW PURCHASE
			 */	
			public void viewAllPurchases() {
				
				//Purchase pMenu=firstPurchase; 
				Booking thebooking=firstBooking;
				while(thebooking!=null) {		
			
					Purchase pMenu=thebooking.firstPurchase; 
					
					System.out.println("Booking Details: "+"===================\n " +
							"\t" + "Booking No.: "+thebooking.bookingNumber +" \n " +
							"\t" + "Table: "+thebooking.getTableNumberBooked()+" \n " +
							"\t" + "Customer Name: "+thebooking.getCustomerName());
					
					while(pMenu!=null){
								//process Booking here....
								System.out.println("Purchase Details: "+" \n " +
								"\t" + "Purchase No.: "+pMenu.getPurchaseNumber() +" \n " +
								"\t" + "FoodItem being Purchased: "+pMenu.getItemPurchased()+" \n " +
								"\t" + "Quantity: "+pMenu.getQuantity());
								pMenu=pMenu.next;
							}
					thebooking=thebooking.next;
				}
			}
				
			/**
			 * METHOD TO DELETE A PURCHASE
			 */	
			public void deletePurchases(String itemP, Booking booking) {
//				!!!! *ASK LECTURER IF THE PROBLEM IS THAT IT HAS TO POINT TO AN ID TO DELETE I.E. PROMPT 'ENTER BOOKING ID TO DELETE FOOD ITEM PURCHASED' !!! 
				Purchase temp5=booking.firstPurchase,temp6=null;
				
				while(temp5!=null && !temp5.itemPurchased.equals(itemP)) { 
					temp6=temp5;
					temp5 = temp5.next;
				}
				
				if(temp5!=null) { //found it
				
					if(temp6!=null) temp6.next=temp5.next; //not at the head
					else firstFdItem=firstFdItem.next; //delete the head
					System.out.println("Item "+itemP+" deleted.");
				}
				else {//not found
					System.out.println("Item "+itemP+" not found.");
				} 
			}	
			
			
			
			
		/*	 
			 public void deletePurchases(String itemP) {
				//ASK LECTURER IF THE PROBLEM IS THAT IT HAS TO POINT TO AN ID TO DELETE I.E. PROMPT 'ENTER BOOKING ID TO DELETE FOOD ITEM PURCHASED'
				//Find booking to add purchase to
				Booking thebooking=firstBooking;
				
				int bid = input.nextInt();
				Purchase temp5=firstPurchase,temp6=null;
				
				while(thebooking.getbookingNumber()!=bid && temp5!=null && !temp5.itemPurchased.equals(itemP)) { 
					temp6=temp5;
					temp5 = temp5.next;
				}
				if(temp5!=null) { //found it
				
					if(temp6!=null) temp6.next=temp5.next; //not at the head
					else firstFdItem=firstFdItem.next; //delete the head
					System.out.println("Item "+itemP+" deleted.");
				}
				else {//not found
					System.out.println("Item "+itemP+" not found.");
				} 
			}*/
			
			
			/*
	====================================================================================		
			
	
 System.out.print("Enter Booking Id for Purchase: ");
				int bid = input.nextInt();
				
				//Find booking to add purchase to
				Booking thebooking=firstBooking;
				
				if(thebooking==null){
					System.out.println("No Bookings Found!"); //no booking found....
					return; 
					}
				else{ 
					while(thebooking.getbookingNumber()!=bid) thebooking=thebooking.next;
				}
 
 ==========================================================================================
			 	public void deleteFoodItems(String item) {
				FoodDrinkMenu temp1=firstFdItem,temp2=null;
				
				while(temp1!=null && !temp1.getFdMenuItem().equals(item)) { 
					temp2=temp1;
					temp1 = temp1.next;
				}
				
				if(temp1!=null) { //found it
				
					if(temp2!=null) temp2.next=temp1.next; //not at the head
					else firstFdItem=firstFdItem.next; //delete the head
					System.out.println("Item "+item+" deleted.");
				}
				else {//not found
					System.out.println("Item "+item+" not found.");
				} 

				}	
			 */
			
			
			
			/**
			 * !!! HERE I CREATE THE METHOD TO LIST ALL TABLES AND ALL BOOKINGS !!!!
			 */
			//Method to view Tables added
			public void viewAllTablesAndBookings() {
				Table temp=headTable;
				Booking temp2=firstBooking; 
				
				while(temp!=null && temp2!=null){
					System.out.print("Table Details: "+" \n " +
					"\t" + "Table No. "+temp.getTableNumber() +" \n " +
					"\t" + "No. of Seats "+temp.getNumberOfSeats()+ " \n ");
					System.out.println("Booking Details:"+" \n " +
					"\t" + "Booking No.: "+temp2.getbookingNumber() +" \n " +
					"\t" + "Customer Name: "+temp2.getCustomerName()+" \n " +
					"\t" + "Number of People Booking: "+temp2.getNumberOfPplBooking()+" \n " +
					"\t" + "Table Number Booked: "+temp2.getTableNumberBooked()+" \n " +
					"\t" + "Booking Time: "+temp2.getBookingTime()+" \n " +
					"\t" + "The Amount of time (in hours) the booking is for: "+temp2.getAmountOfTimeBooking());
					temp=temp.next;
					temp2=temp2.next;	
				}
			}
			
			
			
			/**
			 * METHOD TO RESET THE SYSTEM
			 */
			 public void reset() {
				  headTable=null;
			
			System.out.println("Reset Successful");
			 }
}
