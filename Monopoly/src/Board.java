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

	}
	
}
