import java.util.*;
public class CarLotMain {
	
	static Scanner input = new Scanner(System.in);
	static CarLot inventory = new CarLot();
	
	public static void main(String[] args) {
		int option = 1;
	
		while(option != 0) {
		displayMenu();
		option = input.nextInt();
		menuChoice(option);
		}
	}

	public static void displayMenu() {
		System.out.print("[0] Exit\n"
				+ "[1] Add a car to inventory\n"
				+ "[2] Sell a car from inventory\n"
				+ "[3] List inventory by order of acquisition\n"
				+ "[4] List Inventory From Best MPG to Worst MPG\n"
				+ "[5] Display car with best MPG\n"
				+ "[6] Display car with the highest mileage\n"
				+ "[7] Display overall MPG for the entire inventory\n"
				+ "[8] Display profit for all sold cars\n"
				+ "Enter a number from 0 to 8 : ");
	}
	
	public static void menuChoice(int option) {
		System.out.println();
		switch (option) {
		case 1:
			addCarToInventory();
			break;
		case 2:
			if(inventory.getSize() == 0) {
				System.out.println("There are no cars to be sold.\n");
				break;
			}
			sellCarFromInventory();
			break;
		case 3:
			listInventoryByOrderOfAcquisition();
			break;
		case 4:
			listInventoryByBestMPGToWorstMPG();
			break;
		case 5:
			listCarWithBestMPG();
			break;
		case 6:
			listCarWithHighestMileage();
			break;
		case 7:
			listOverallMPGForInventory();
			break;
		case 8:
			listProfitForAllSoldCars();
			break;
		}
	}
	public static void addCarToInventory() {
		System.out.println("Input info for the car that is being added: ");
		
		System.out.print("Enter car's ID: ");
			input.nextLine();
			String ID = input.nextLine();
		System.out.print("Enter car's Mileage: ");
			int Mileage = input.nextInt();
		System.out.print("Enter car's MPG: ");
			int MPG = input.nextInt();
		System.out.print("Enter car's Cost: ");
			double cost = input.nextDouble();
		System.out.print("Enter car's Sales Price: ");
			double salesPrice = input.nextDouble();
		
		inventory.addCar(ID, Mileage, MPG, cost, salesPrice);
		
		System.out.println(ID + " was added.");
		
		System.out.println("Press enter to continue to main menu.");
		input.nextLine();
		input.nextLine();
	}
	public static void sellCarFromInventory() {
		System.out.println("Input info for the car that is being sold: ");
		
		System.out.print("Enter car's ID: ");
			input.nextLine();
			String ID = input.nextLine();
		System.out.print("Enter the price the car was sold for: ");
			double sellingPrice = input.nextDouble();
			
		inventory.sellCar(ID, sellingPrice);
		
		if(inventory.findCarByIdentifier(ID) == null) {
			
		}
		
		else {
			System.out.println(ID + " was sold.");
		}
		
		System.out.println("Press enter to continue to main menu.");
		input.nextLine();
		input.nextLine();
		
	}
	public static void listInventoryByOrderOfAcquisition() {
		System.out.println("Listing of cars in order of acquisition: ");
		for (int i = 0; i < inventory.getSize(); i++) {
			System.out.println(inventory.getCar(i));
		}
		System.out.println("Press enter to continue to main menu.");
		input.nextLine();
		input.nextLine();
	}
	public static void listInventoryByBestMPGToWorstMPG() {
		System.out.println("Listing of cars in order of best MPG to worst MPG: ");
		ArrayList<Car> carsWorstMPGToBestMPG = inventory.getCarsSortedByMPG();
		for (int i = inventory.getSize() - 1; i >= 0; i--) {
			System.out.println(carsWorstMPGToBestMPG.get(i).getID() + ", MPG: " 
		+ carsWorstMPGToBestMPG.get(i).getMPG());
		}
		System.out.println("Press enter to continue to main menu.");
		input.nextLine();
		input.nextLine();
	}
	public static void listCarWithBestMPG() {
		System.out.print("Car with best MPG: ");
		System.out.print(inventory.getCarWithBestMPG().getID() + ", MPG: " 
		+ inventory.getCarWithBestMPG().getMPG() + "\n");
		System.out.println("Press enter to continue to main menu.");
		input.nextLine();
		input.nextLine();
	}
	public static void listCarWithHighestMileage() {
		System.out.print("Car with highest mileage: ");
		System.out.print(inventory.getCarWithHighestMileage().getID() + ", Mileage: "
		+ inventory.getCarWithHighestMileage().getMileage() + "\n");
		System.out.println("Press enter to continue to main menu.");
		input.nextLine();
		input.nextLine();
	}
	public static void listOverallMPGForInventory() {
		System.out.print("Overall MPG for inventory: ");
		System.out.print(inventory.getAverageMPG()+"\n");
		System.out.println("Press enter to continue to main menu.");
		input.nextLine();
		input.nextLine();
	}
	public static void listProfitForAllSoldCars() {
		System.out.print("Profit of all the sold cars: ");
		System.out.printf("$%.2f\n",inventory.getTotalProfit());
		System.out.println("Press enter to continue to main menu.");
		input.nextLine();
		input.nextLine();
	}
	
}

