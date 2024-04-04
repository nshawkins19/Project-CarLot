import java.awt.Desktop;
import java.io.*;
import java.util.*;
public class CarLot extends ArrayList<Car>{

	public CarLot() {

	}

	/**
	 * The findCarByIdentifier returns the Car in inventory that matches the
	 * identifier
	 * 
	 * @param String identifier
	 */
	Car findCarByIdentifier(String identifier) {
		for (int i = 0; i < super.size(); i++) {
			String IDofCarGettingCompared = super.get(i).getID();
			if (IDofCarGettingCompared.equalsIgnoreCase(identifier)) {
				return super.get(i);
			}

		}
		
		return null;
	}

	/**
	 * The getCarsInOrderOfEntry returns the Car list sorted by entry
	 * 
	 * @return
	 */
	Car[] getCarsInOrderOfEntry() {
		Car[] sortedCarList = null;
		sortedCarList = super.toArray(new Car[super.size()]);
		return sortedCarList;
	}

	ArrayList<Car> getCarsSortedByMPG() {
		ArrayList<Car> SortedCarList = (ArrayList<Car>) super.clone();
		Collections.sort(SortedCarList, new Comparator<Car>() {
			public int compare(Car c1, Car c2) {
				int mpg1 = c1.getMPG();
				int mpg2 = c2.getMPG();
				if (mpg1 > mpg2)
					return 1;
				if (mpg1 == mpg2)
					return 0;
				else
				return -1;
			}
		});

		return SortedCarList;
	}

	ArrayList<Car>  getCarsSortedByMileage() {
		ArrayList<Car> SortedCarList = (ArrayList<Car>) super.clone();
		Collections.sort(SortedCarList, new Comparator<Car>() {
			public int compare(Car c1, Car c2) {
				int mile1 = c1.getMileage();
				int mile2 = c2.getMileage();
				if (mile1 > mile2)
					return 1;
				if (mile1 == mile2)
					return 0;
				return -1;
			}
		});

		return SortedCarList;
	}

	/**
	 * The getCarWithBestMpg returns the Car with highest mpg
	 * 
	 * @return
	 */
	Car getCarWithBestMPG() {
		ArrayList<Car> newList = getCarsSortedByMPG();
		Collections.reverse(newList);
		return newList.get(0);

	}

	/**
	 * The getCarWithHighestMileage returns the Car with highest mileage
	 * 
	 * @return
	 */
	Car getCarWithHighestMileage() {
		ArrayList<Car> newList = getCarsSortedByMileage();
		Collections.reverse(newList);
		return newList.get(0);
	}

	/**
	 * The getAverageMPG method returns the average MPG of all cars in inventory
	 * 
	 * @return
	 */
	double getAverageMPG() {
		int totalMPG = 0;
		int count = 0;
		for (int i = 0; i < super.size(); i++) {
			if (super.get(i).getSold() == false) {
				totalMPG += super.get(i).getMPG();
				count++;
			}
		}
		double average = Double.valueOf(totalMPG) / Double.valueOf(count);
		return average;
	}

	/**
	 * The getTotalProfit method returns the total profit for all sold cars
	 * 
	 * @return
	 */
	double getTotalProfit() {
		int totalProfit = 0;
		for (int i = 0; i < super.size(); i++)
			if (super.get(i).getSold()) {
				totalProfit += super.get(i).getProfit();
			}
		;
		return totalProfit;
	}

	/**
	 * The addCar method creates a new car in CarList
	 * 
	 * @param String id, int mileage, int mpg, double cost, double salesPrice
	 */
	void addCar(String id, int mileage, int mpg, double cost, double salesPrice) {
		Car newCar = new Car();
		newCar.setID(id);
		newCar.setMileage(mileage);
		newCar.setMPG(mpg);
		newCar.setCost(cost);
		newCar.setSalesPrice(salesPrice);
		super.add(newCar);
	}
	
	/**
	 * The sellCar method changes sold to true, sets priceSold, and sets profit to
	 * priceSold - Cost
	 * 
	 * @param String identifier, double priceSold
	 */
	void sellCar(String identifier, double priceSold) {

		// Creates a string of CarList that will be used for a comparison later on in
		// method
		String carListBefore = super.toString();

		/*
		 * Goes through all of the car objects identifications in CarList and if a match
		 * is found it sets the sold status of that car object to true and sets the
		 * price it was sold for
		 */
		for (int i = 0; i < super.size(); i++) {
			String compareCar = (super.get(i)).toString();
			int beforeID = compareCar.indexOf("Car");
			int afterID = compareCar.indexOf(",");
			String IDofCarGettingCompared = compareCar.substring(beforeID + 5, afterID);
			if (IDofCarGettingCompared.equals(identifier)) {
				(super.get(i)).setSold(true);
				(super.get(i)).setPriceSold(priceSold);
				(super.get(i)).setProfit(priceSold - super.get(i).getCost());
			}
		}

		// Going to be used for a comparison
		String carListAfter = super.toString();

		/*
		 * Checking if Carlist before the for loop has been changed at all. If CarList
		 * has not been changed then that means there was no car object that matched
		 * that identifier
		 */
		if (carListBefore.equals(carListAfter)) {
			System.out.println("A car with the identifier '" + identifier + "' does not exist.");
		}

	}
	
	// Gets size of the car list aka the number of cars in the arraylist
	int getSize() {
		return super.size();
	}
	
	// Gets a car at certian point within the array list
	Car getCar(int i) {
		return super.get(i);
	}
	
	// Saves car object to a txt file
	void saveToDisk(java.io.File carlot) {
		
		// Write to file
		try {
			java.io.PrintWriter output = new java.io.PrintWriter(carlot);
			for (int i = 0; i < super.size(); i++) {
				output.println(super.get(i).toString());
			}
			output.close();
		}
		catch(Exception e) {
			System.out.println("car could no be added to carlot.txt\n");
		}
		
		// Open file
		try {
			Desktop.getDesktop().open(new File("carlot.txt"));
			//This syntax will vary depending on OS
		
			
					}
		catch(Exception e) {
			System.out.println("Could not open carlot.txt");
		}
	}
	
	// Loads cars from a txt file into program
	void loadFromDisk() {
		System.out.println("Loading in inventory from disk:");
		try {
		File carlot = new File("carlot.txt");
		//This syntax will vary depending on OS
		Scanner scan = new Scanner(carlot);
		while(scan.hasNextLine()) {
			Car car = new Car();
			String line = scan.nextLine();
			System.out.println(line);
			car = convetStringToCar(line);
			super.add(car);
			}
		scan.close();
		}
		catch(Exception e) {
			System.out.println("carlot.txt could not load");
		}
		System.out.println();
		
	}
	
	Car convetStringToCar (String s) {
		
		Car car = new Car();
		
		// Get ID
		int beforeID = s.indexOf("Car");
		int afterID = s.indexOf(",");
		String ID = s.substring(beforeID + 5, afterID);
		car.setID(ID);
		
		// Get Mileage
		int beforeMileage = s.indexOf("Mileage");
		int afterMileage = s.indexOf("miles");
		String mileageString = s.substring(beforeMileage + 9, afterMileage-1);
		int mileage = Integer.parseInt(mileageString);
		car.setMileage(mileage);
		
		// Get MPG
		int beforMPG = s.indexOf("MPG");
		int afterMPG = s.indexOf("miles per gallon");
		String MPGString = s.substring(beforMPG + 5, afterMPG - 1);
		int MPG = Integer.parseInt(MPGString);
		car.setMPG(MPG);
		
		// Get Sold
		int beforeSold = s.indexOf("Sold");	
		int afterSold = s.indexOf("Cost");
		String soldString = s.substring(beforeSold + 6, afterSold - 3);
		car.setSold(false);
		if(soldString.equals("Yes")) {
			car.setSold(true);
		}
		
		
		// Get Cost
		int beforeCost = s.indexOf("Cost");
		int afterCost = s.indexOf("Selling Price");
		String CostString = s.substring(beforeCost + 7, afterCost - 3);
		double Cost = Double.parseDouble(CostString);
		car.setCost(Cost);
		
		// Get Selling Price
		int beforeSalesPrice = s.indexOf("Selling Price");
		int afterSalesPrice = s.indexOf("Sold For");
		String salesPriceString = s.substring(beforeSalesPrice + 16, afterSalesPrice - 3);
		double salesPrice = Double.parseDouble(salesPriceString);
		car.setSalesPrice(salesPrice);			
		
		// Get Sold For
		int beforeSoldFor = s.indexOf("Sold For");
		int afterSoldFor = s.indexOf("Profit");
		String soldForString = s.substring(beforeSoldFor + 10, afterSoldFor - 3);
		double soldFor = Double.parseDouble(soldForString);
		car.setPriceSold(soldFor);
		
		// Get Profit
		int beforeProfit = s.indexOf("Profit");
		int afterProfit = s.length();
		String profitString = s.substring(beforeProfit + 9, afterProfit);
		double profit = Double.parseDouble(profitString);
		car.setProfit(profit);
		
		return car;
	}
}
