import java.util.*;
import java.io.*;

public class CarLotTester {

	public static void main(String[] args) throws Exception{
	
		
		CarLot inventory = new CarLot ();
		
		inventory.addCar("BMW 330i", 46292, 26, 32000, 35000);
		
		inventory.addCar("Toyota 4Runner", 34311, 30, 25000, 28000);
	
		inventory.addCar("Ford Ranger", 85913, 26, 23000, 26000);
		
		inventory.sellCar("BMW 330i", 40000);
		
//		System.out.println(inventory.findCarByIdentifier("Kia Sorrento"));
//		
//		System.out.println("Inventory in order of Entry: " + inventory.getCarsInOrderOfEntry());
//		
//		System.out.println("Inventory in order of Mileage: " + inventory.getCarsSortedByMileage());
//		
//		System.out.println("Inventory in order of Fuel Efficiency: " + inventory.getCarsSortedByMPG());
//		
//		System.out.println("Car with best fuel efficiency: "+inventory.getCarWithBestMPG().getID());
//		
//		System.out.println("Car with highest mileage: "+inventory.getCarWithHighestMileage().getID());
//		
//		System.out.printf("Average MPG on all cars on the lot: %.2f miles per gallon\n" ,inventory.getAverageMPG());
		
		System.out.printf("Profit: $%.2f\n",inventory.getTotalProfit());
		
		java.io.File carlot = new java.io.File("carlot.txt");
	
		inventory.saveToDisk(carlot);
		
		inventory.loadFromDisk();
		
		
	}

}
