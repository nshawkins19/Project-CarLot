import java.util.*;

public class CarTester {

	public static void main(String[] args) throws Exception {
		
		//Constructor Syntax:
		//Car(String newID, int newMileage, double MPG, double Cost, double SalesPrice, boolean Sold, double FinalPrice, double Profit)
		
		
		//Default 
		Car car1 = new Car("BMW",90000,23,5000,10000,true,7500,(10000-7500));
		
		//Constructor
		Car car2 = new Car();
		
	
			//Storing attributes for car 2
			car2.setCost(20000);
			car2.setID("Camaro");
			car2.setMileage(25000);
			car2.setMPG(23);
			car2.setSold(false);
			car2.setSalesPrice(12000);
			
		
		System.out.println(car1.toString());
		
		System.out.println();
			
		System.out.println(car2.toString());
		
		System.out.println();
		
		// Testing the compareMiles() method ==> Method returns a number, then prints a message to the user
		switch (car1.compareMiles(car2)) {
		
			case 1: 
				System.out.println("The "+car1.getID()+ " has more miles than the "+car2.getID());
				break;
				
			case -1:
				System.out.println("The "+car2.getID()+ " has more miles than the "+car1.getID());
				break;
			
			default: 
				System.out.println("The "+car1.getID()+ "and the " +car2.getID()+" have the same mileage!");
				break;
			
		} //end switch
		
		System.out.println();
		
		
		
		// Testing the compareMPG() method ==> Method returns a number, then prints a message to the user
		switch (car1.compareMPG(car2)) {
				
			case 1: 
				System.out.println("The "+car1.getID()+ " is more fuel efficient than the "+car2.getID());
				break;
					
			case -1:
				System.out.println("The "+car2.getID()+ " is more fuel efficient than the "+car1.getID());
				break;
					
			default: 
				System.out.println("The "+car1.getID()+ " and the " +car2.getID()+" have the same fuel efficiency!");
				break;
					
		} //end switch
		
		
				System.out.println();
				
				
		// Testing the comparePrice() method ==> Method returns a number, then prints a message to the user
		 
		switch (car1.comparePrice(car2)) {
		
		case 1: 
			System.out.println("The "+car1.getID()+ " is more expensive than the "+car2.getID());
			break;
				
		case -1:
			System.out.println("The "+car2.getID()+ " is more expensive than the "+car1.getID());
			break;
				
		default: 
			System.out.println("The "+car1.getID()+ " and the " +car2.getID()+" are the same price!");
			break;
				
		} //end switch	
		
	} //end main
	

} //end class
