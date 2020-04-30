package reservation_project;

import java.util.Scanner;
import java.util.Date;

public class Reservation {
	//Array of 12 seats
     private static int[] seats = new int[12];
     
     
     public static void main(String args[]) {
    	 System.out.println("Welcome to the JetBlue Reservation System");
    	 System.out.println("Please choose a seat preference for your ride");
    	 System.out.println();
    	 
    	 //Set all seats to 0
    	 for (int i = 0; i <12; i++){
    		 seats[i] = 0;
    	 }
    	 
    	 //Scanner & Default Choice to window
    	 Scanner s = new Scanner(System.in);
    	 int choice = 1;
    	 
    	 //Ask User for seat preference
    	 System.out.print("Please enter 1 for a Window Seat, 2 for an Aisle Seat or 0 to Exit:");
    	 choice = s.nextInt();
    	 
    	 //while(choice != 0) {
    		 int seatnumber = 0;
    		 
			// If they chose a window seat, book.
    		 if(choice == 1) {

    			 seatnumber = bookWindow();
    			 System.out.println("You're in luck, we have a window seat for you");
    			 
    			
    			 // No window seats available, book aisle seat
    			 if(seatnumber == -1) {
    				seatnumber = bookAisle();
    				
    				if(seatnumber != -1) {
    					System.out.println("Sorry, were not able to book a window seat. But we do have an aisle seat");
    					printBoardingPass(seatnumber);
    				}
    				}
    			 }
    		 //}
    	 
    	
    		 else if (choice ==2) {
    		 //If they choose to book an aisle, check if available
			System.out.println("You're in luck, we have a aisle seat.");
    		seatnumber = bookAisle();
    		 
    		 if (seatnumber == -1) {
    			 seatnumber = bookWindow();
    			 
    			 if (seatnumber != -1) {
    				 System.out.println("Sorry, we were not able to book an aisle Seat");
    				 printBoardingPass(seatnumber);
    				 
    			 }
    		 }
    		 
    	 }
    	 else{
    		 //Error message if no choice
    		 System.out.println("Invalid choice. Please try again.");
    		 choice = 0;
    	 }
     }

     
    	 
//Function checks for window seat, returns seat number or -1 if full
private static int bookWindow() {
	for (int i = 0; i < 6; i++) {
		if (seats[i] == 0) {
			seats[i] = 1;
			return i + 1;
		}
	}
	return -1;
}
    	 
    	 
 //Function checks for aisle seats, returns seat number of -1 if full
private static int bookAisle() {
	for (int i = 6; i <12; i++ ) {
		if(seats[i] == 0) {
			seats[i] = 1;
			return i + 1;
		}
	}
	return -1;
}

//Boarding pass message

public static void printBoardingPass(int seatnumber) {
	Date timenow = new Date();
	System.out.println();
	System.out.println("Date:" + timenow.toString());
	System.out.println("Boarding pass for seat number:" + seatnumber);
	System.out.println("This ticket is non-refundable and non-transferable");
}
}
