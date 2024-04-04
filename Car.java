import java.util.*;
public class Car {
	
	//Creating data fields for car specifics
		private String ID;
		private int mileage;
		private int mpg;
		private double cost;
		private double salesPrice;
		private boolean sold;
		private double finalPrice;
		private double profit;
		
		
		//Default car constructor
		public Car(){
			ID="";
			mileage=0;
			mpg=0;
			cost=0;
			salesPrice=0;
			sold=false;
			finalPrice=0;
			profit=0;

		}
		
		protected ArrayList <Car> CarList = new ArrayList<>();
		
		/**
		 * Constructor for a Car object
		 * @param newID
		 * @param newMileage
		 * @param newMPG
		 * @param newCost
		 * @param newSalesPrice
		 * @param newSold
		 * @param newFinalPrice
		 * @param newProfit
		 */
		public Car(String newID, int newMileage, int newMPG, double newCost, double newSalesPrice, boolean newSold, double newFinalPrice, double newProfit) {
			ID = newID;
			mileage = newMileage;
			mpg = newMPG;
			cost = newCost;
			salesPrice = newSalesPrice;
			sold = newSold;
			finalPrice = newFinalPrice;
			profit = newProfit;
		}
		/**
		 * The setCost method stores a value in the cost field
		 * @param Cost
		 */
		public void setCost(double Cost) {
			cost = Cost;
		}
		
		/**
		 * The setSalesPrice method stores a value in the salesPrice field
		 * @param price
		 */
		public void setSalesPrice(double price) {
			salesPrice = price;
		}
		
		/**
		 * The setSold method stores a value in the sold field
		 * @param Sold
		 */
		public void setSold (boolean Sold) {
			sold = Sold;
		}
		
		/**
		 * The setPriceSold method stores a value in the finalPrice field
		 * @param price
		 */
		public void setPriceSold (double price) {
			finalPrice = price;
		}
		
		/**
		 * The setProfit method stores a value in the profit field
		 * @param Profit
		 */
		public void setProfit (double Profit) {
			profit = Profit;
		}
		
		/**
		 * The setID method stores a string value to the ID field
		 * @param id
		 */
		public void setID (String id) {
			ID = id;
		}
		

		/**
		 * The setMileage method stores a value in the mileage field
		 * @param miles
		 */
		public void setMileage (int miles) {
			mileage = miles;
		}
		
		/**
		 * The setMPG method stores a value in the mpg field
		 * @param MPG
		 */
		public void setMPG (int MPG) {
			mpg = MPG;
	
		}
		
		/**
		 * The getID method retrieves the value in the ID field
		 * @return
		 */
		public String getID (){
			return ID;
		}
		
		/**
		 * The getMPG method retrieves the value in the mpg field
		 * @return
		 */
		public int getMPG () {
			return mpg;
		}
		
		public int getMileage()
		{
			return mileage;
		}
		
		/**
		 * The getCost method retrieves the value in the cost field
		 * @return
		 */
		public double getCost () {
			return cost;
		}
		
		/**
		 * THe getSalesPrice method retrieves the value in the salesPrice field
		 * @return
		 */
		public double getSalesPrice () {
			return salesPrice;
		}
		
		/**
		 * The getSold method retrieves the value in sold field
		 * @return
		 */
		public boolean getSold () {
			return sold;
		}
		
		/**
		 * The getFinalPrice method retrieves the value in the finalPrice field
		 * @return
		 */
		public double getFinalPrice () {
			return finalPrice;
		}
		
		public double getProfit()
		{
			return profit;
		}
		
		/**
		 * The getSoldResponse method retrieves the value in the sold field, then returns the string :
		 * 		"yes" if sold == true
		 * 		"no" if sold == false
		 * 
		 * @return
		 */
		public String getSoldResponse()
		{
			if(sold)
			{
				return "Yes";
			}
			else
				return "No";
		}
		
		
		/**
		 * The toString method provides info for a car object in an easy to read format
		 */
		public String toString() {
			
			String info = "Car: " +ID+ ",  Mileage: " + mileage + " miles, " + " MPG: " + mpg + " miles per gallon, "+" Sold: "+ getSoldResponse() + " Cost: $" + (int) cost + ", " + " Selling Price: $" + (int) salesPrice + ", " 
		+ " Sold For $" + (int)finalPrice + ", " + " Profit: $" + (int)profit;
			
			return info;
		}
		
		public String toStringAbbrev()
		{
			
			return ID;
		}
		
		/**
		 * The sellCar method sets a car object's sold field equal to 'true' and sets the finalPrice field as the parameter priceSold
		 * @param priceSold
		 */
		public void sellCar(double priceSold)
		{
			sold=true;
			finalPrice=priceSold;
		}
		
		/**
		 * The compareMPG method compares the mpg fields of two Car objects
		 * @param car2
		 * @return
		 */
		public int compareMPG(Car car2)
		{
			if (mpg>car2.mpg)
			{
				return 1;
			}
			else if (mpg < car2.mpg)
			{
				return -1;
			}
			else
			{
				return 0;
			}
			
		}
		
		/**
		 * The compareMiles method compares the mileage fields of two Car objects
		 * @param car2
		 * @return
		 */
		public int compareMiles(Car car2)
		{
			if (mileage>car2.mileage)
			{
				return 1;
			}
			else if (mileage < car2.mileage)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}
		
		/**
		 * The comparePrice method compares the salesPrice fields of two Car objects
		 * @param car2
		 * @return
		 */
		public int comparePrice (Car car2) {
			
			if (salesPrice>car2.salesPrice)
			{
				return 1;
			}
			else if (salesPrice < car2.salesPrice)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}
				
		public void add (Car car){
			
			CarList.add(car);
		}
		
	}

	
