import java.io.Serializable;

public class Booking implements Serializable {
	public int bookingNumber;
	public String customerName;
	public int numberOfPplBooking;
	public int tableNumberBooked;
	public int bookingTime;
	public int amountOfTimeBooking;
	public Booking next = null;
	public Purchase firstPurchase = null;

	
	//public activeBookings;
	
	
	public Booking(int bookingNumber, String customerName, int numberOfPplBooking, int tableNumberBooked, int bookingTime,
			int amountOfTimeBooking) {
		//super();
		this.bookingNumber = bookingNumber;
		this.customerName = customerName; //.substring(0, 30);
		this.numberOfPplBooking = numberOfPplBooking;
		this.tableNumberBooked = tableNumberBooked;
		this.bookingTime = bookingTime;
		this.amountOfTimeBooking = amountOfTimeBooking;
	}
	
	
	public int getbookingNumber() {
		return bookingNumber;
	}
	public void setBookingNumber(int bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
	
	public String getCustomerName() {
		
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		//if (customerName.length() <= 30)
		this.customerName = customerName;
	}	
			//this.customerName = customerName; //.substring(0, 30);
	
	
	public int getNumberOfPplBooking() {
		return numberOfPplBooking;
	}
	public void setNumberOfPplBooking(int numberOfPplBooking) {
		this.numberOfPplBooking = numberOfPplBooking;
	}
	public int getTableNumberBooked() {
		return tableNumberBooked;
	}
	public void setTableNumberBooked(int tableNumberBooked) {
		this.tableNumberBooked = tableNumberBooked;
	}
	public int getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(int bookingTime) {
		this.bookingTime = bookingTime;
	}
	public int getAmountOfTimeBooking() {
		return amountOfTimeBooking;
	}
	public void setAmountOfTimeBooking(int amountOfTimeBooking) {
		this.amountOfTimeBooking = amountOfTimeBooking;
	}
	
	/*public String checkerForBookings() {
	if (Booking.size() == 0) // checking for if there are no members in the gym return that there are none
		return "There are no members in the gym";
	}*/
	
	
//	System.out.println("Table "+nt.tableNumber+" ("+nt.numberOfSeats+" seats)");
	//		nt=nt.next;
		
		
	@Override
	public String toString() {
		return "Booking [bookingNumber=" + bookingNumber
				+ ", customerName=" + customerName
				+ ", numberOfPplBooking=" + numberOfPplBooking
				+ ", tableNumberBooked=" + tableNumberBooked
				+ ", bookingTime=" + bookingTime
				+ ", amountOfTimeBooking=" + amountOfTimeBooking + "]";
	}


	/*public static int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String checkerForBookings() {
		String c ="";
		if (Booking.size() == 0) {// checking for if there are no members in the gym return that there are none
			return "There are no members in the gym";
		}
		return c;
	
	}*/
}
	/*@Override
	public String toString() {
		return "Booking [customerName=" + customerName + ", numberOfPplBooking=" + numberOfPplBooking
				+ ", tableNumberBooked=" + tableNumberBooked + ", bookingTime=" + bookingTime + ", amountOfTimeBooking="
				+ amountOfTimeBooking + "]";
	}
	

	*/
	

/**
 * Contains a save method to save, hence "void save" the data that was inputed
 * into the system while the it is running in the Menu Controller (which is
 * controlling the members class and the gym class)
 * 
 * @throws Exception
 */

/*
	public static void save(WelcomeMenuController app) throws Exception {
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Tables.xml"));
		out.writeObject(app);
		out.close();
	}
	
	 * Suppresses the errors that displays on the consoles and contains a load
	 * method to load, hence "void load" the saved once the system is running in the
	 * Menu Controller (which is controlling the members class and the gym class)
	 * 
	 * @throws Exception
	 
	
	@SuppressWarnings("unchecked")
	public static WelcomeMenuController load() throws Exception {
		XStream xstream = new XStream(new DomDriver());
		ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Tables.xml"));
		members = (ArrayList<Member>) is.readObject();
		WelcomeMenuController app=(WelcomeMenuController)is.readObject();
		
		is.close();
		return app;
	}*/

	
	

