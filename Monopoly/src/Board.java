import java.util.ArrayList;

// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// Board.java

public class Board {
	
	// global variables
	private Square squares[] = new Square[41];
	
	public Square getSquare(int squareID){
		return null;
	}
	
	private void setupBoard(){
		// Setting up squares	
		Go go = new Go(0, "Go");
		RealEstate Mediterranean_Avenue = new RealEstate(1, "Mediterranean Avenue", 60, 50, 2, 1);
		Square commChest1 = new Square(2, "Community Chest");
		RealEstate Baltic_Avenue = new RealEstate(3, "BalticAvenue", 60, 50, 4, 1);
		Tax Income_Tax = new Tax(4, "Income Tax");
		RailroadsAndUtilities Reading_Railroad = new RailroadsAndUtilities(5, "Reading Railroad", 200);
		RealEstate Oriental_Avenue = new RealEstate(6, "Oriental Avenue", 100, 50, 6, 2);
		Square chance1 = new Square(7, "Chance");
		RealEstate Vermont_Avenue = new RealEstate(8, "Vermont Avenue", 100, 50, 6, 2);
		RealEstate Connecticut_Avenue = new RealEstate(9, "Connecticut Avenue", 120, 50, 8, 2);
		Square Just_Visiting = new Square(10, "Just Visiting");
		RealEstate St_Charles_Place = new RealEstate(11, "St. Charles Place", 140, 100, 10, 3);
		RailroadsAndUtilities Electric_Company = new RailroadsAndUtilities(12, "Electric Company", 150);
		RealEstate St_Charles_Place = new RealEstate(13, "States Avenue", 140, 100, 10, 3);
		RealEstate Virginia_Avenue = new RealEstate(14, "Virginia Avenue", 160, 100, 12, 3);
		RailroadsAndUtilities Pennsylvania_Railroad = new RailroadsAndUtilities(15, "Pennsylvania Railroad", 200);
		RealEstate St_James_Place = new RealEstate(16, "St. James Place", 180, 100, 14, 4);
		Square commChest2 = new Square(17, "Community Chest");
		RealEstate Tennessee_Avenue = new RealEstate(18, "Tennessee Avenue", 180, 100, 14, 4);
		RealEstate New_York_Avenue = new RealEstate(19, "New York Avenue", 200, 100, 16, 4);
		Square freePark = new Square(20, "Free Parking");
		RealEstate Kentucky_Avenue = new RealEstate(21, "Kentucky Avenue", 220, 150, 18, 5);
		Square chance2 = new Square(22, "Chance");
		RealEstate Indiana_Avenue = new RealEstate(23, "Indiana Avenue", 220, 150, 18, 5);
		RealEstate Illinois_Avenue = new RealEstate(24, "Illinois Avenue", 240, 150, 20, 5);
		RailroadsAndUtilities B_O_Railroad = new RailroadsAndUtilities(25, "B. & O. Railroad", 200);
		RealEstate Atlantic_Avenue = new RealEstate(26, "Atlantic Avenue", 260, 150, 22, 6);
		RealEstate Ventnor_Avenue = new RealEstate(27, "Ventnor Avenue", 260, 150, 22, 6);
		RailroadsAndUtilities Water_Works = new RailroadsAndUtilities(28, "Water Works", 150);
		RealEstate Marvin_Avenue = new RealEstate(29, "Marvin Avenue", 280, 150, 24, 6);
		Square goToJail = new Square(30, "Go To Jail");
		RealEstate Pacific_Avenue = new RealEstate(31, "Pacific Avenue", 300, 200, 26, 7);
		RealEstate North_Carolina_Avenue = new RealEstate(32, "North Carolina Avenue", 300, 200, 26, 7);
		Square commChest3 = new Square(33, "Community Chest");
		RealEstate Pennsylvania_Avenue = new RealEstate(34, "Pennsylvania Avenue", 320, 200, 28, 7);
		RailroadsAndUtilities Short_Line = new RailroadsAndUtilities(35, "Short Line", 200);
		Square chance3 = new Square(36, "Chance");
		RealEstate Park_Place = new RealEstate(37, "Park Place", 350, 200, 35, 8);
		Tax Luxury_Tax = new Tax(38, "Luxury Tax");
		RealEstate Boardwalk = new RealEstate(39, "Boardwalk", 400, 200, 50, 8);
		
	}
	
}
