// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// Board.java

import java.util.ArrayList;

public class Board {
	
	// global variables
	private Square squares[] = new Square[41];
	private Player players[] = new Player[4];
	private Dice dice = new Dice();
	public Square getSquare(int squareID){
		return squares[squareID];
	}
	
	private void setupBoard(){
		// Setting up squares	
		Square go = new Square(0, "Go");
		squares[0] = go;
		RealEstate Mediterranean_Avenue = new RealEstate(1, "Mediterranean Avenue", 60, 50, new int []{2,4,10,30,90,160,250}, 1);
		squares[1] = Mediterranean_Avenue;
		Square commChest1 = new Square(2, "Community Chest");
		squares[2] = commChest1;
		RealEstate Baltic_Avenue = new RealEstate(3, "Baltic Avenue", 60, 50, new int []{4,8,20,60,180,320,450}, 1);
		squares[3] = Baltic_Avenue;
		Tax Income_Tax = new Tax(4, "Income Tax");
		squares[4] = Income_Tax;
		RailroadsAndUtilities Reading_Railroad = new RailroadsAndUtilities(5, "Reading Railroad", 200);
		squares[5] = Reading_Railroad;
		RealEstate Oriental_Avenue = new RealEstate(6, "Oriental Avenue", 100, 50, new int []{6,12,30,90,270,400,550}, 2);
		squares[6] = Oriental_Avenue;
		Square chance1 = new Square(7, "Chance");
		squares[7] = chance1;
		RealEstate Vermont_Avenue = new RealEstate(8, "Vermont Avenue", 100, 50, new int []{6,12,30,90,270,400,550}, 2);
		squares[8] = Vermont_Avenue;
		RealEstate Connecticut_Avenue = new RealEstate(9, "Connecticut Avenue", 120, 50, new int []{8,16,40,100,300,450,600}, 2);
		squares[9] = Connecticut_Avenue;
		Square Just_Visiting = new Square(10, "Just Visiting");
		squares[10] = Just_Visiting;
		RealEstate St_Charles_Place = new RealEstate(11, "St. Charles Place", 140, 100, new int []{10,20,50,150,450,625,750}, 3);
		squares[11] = St_Charles_Place;
		RailroadsAndUtilities Electric_Company = new RailroadsAndUtilities(12, "Electric Company", 150);
		squares[12] = Electric_Company;
		RealEstate States_Avenue = new RealEstate(13, "States Avenue", 140, 100, new int []{10,20,50,150,450,625,750}, 3);
		squares[13] = States_Avenue;
		RealEstate Virginia_Avenue = new RealEstate(14, "Virginia Avenue", 160, 100, new int []{12,24,60,180,500,700,900}, 3);
		squares[14] = Virginia_Avenue;
		RailroadsAndUtilities Pennsylvania_Railroad = new RailroadsAndUtilities(15, "Pennsylvania Railroad", 200);
		squares[15] = Pennsylvania_Railroad;
		RealEstate St_James_Place = new RealEstate(16, "St. James Place", 180, 100, new int []{14,28,70,200,550,750,950}, 4);
		squares[16] = St_James_Place;
		Square commChest2 = new Square(17, "Community Chest");
		squares[17] = commChest2;
		RealEstate Tennessee_Avenue = new RealEstate(18, "Tennessee Avenue", 180, 100, new int []{14,28,70,200,550,750,950}, 4);
		squares[18] = Tennessee_Avenue;
		RealEstate New_York_Avenue = new RealEstate(19, "New York Avenue", 200, 100, new int []{16,32,80,220,600,800,1000}, 4);
		squares[19] = New_York_Avenue;
		Square freePark = new Square(20, "Free Parking");
		squares[20] = freePark;
		RealEstate Kentucky_Avenue = new RealEstate(21, "Kentucky Avenue", 220, 150, new int []{18,36,90,250,700,875,1050}, 5);
		squares[21] = Kentucky_Avenue;
		Square chance2 = new Square(22, "Chance");
		squares[22] = chance2;
		RealEstate Indiana_Avenue = new RealEstate(23, "Indiana Avenue", 220, 150, new int []{18,36,90,250,700,875,1050}, 5);
		squares[23] = Indiana_Avenue;
		RealEstate Illinois_Avenue = new RealEstate(24, "Illinois Avenue", 240, 150, new int []{20,40,100,300,750,925,1100}, 5);
		squares[24] = Illinois_Avenue;
		RailroadsAndUtilities B_O_Railroad = new RailroadsAndUtilities(25, "B. & O. Railroad", 200);
		squares[25] = B_O_Railroad;
		RealEstate Atlantic_Avenue = new RealEstate(26, "Atlantic Avenue", 260, 150, new int []{22,44,110,330,800,975,1150}, 6);
		squares[26] = Atlantic_Avenue;
		RealEstate Ventnor_Avenue = new RealEstate(27, "Ventnor Avenue", 260, 150, new int []{22,44,110,330,800,975,1150}, 6);
		squares[27] = Ventnor_Avenue;
		RailroadsAndUtilities Water_Works = new RailroadsAndUtilities(28, "Water Works", 150);
		squares[28] = Water_Works;
		RealEstate Marvin_Gardens = new RealEstate(29, "Marvin Gardens", 280, 150, new int []{24,48,120,360,850,1025,1200}, 6);
		squares[29] = Marvin_Gardens;
		Square goToJail = new Square(30, "Go To Jail");
		squares[30] = goToJail;
		RealEstate Pacific_Avenue = new RealEstate(31, "Pacific Avenue", 300, 200, new int []{26,52,130,390,900,1100,1275}, 7);
		squares[31] = Pacific_Avenue;
		RealEstate North_Carolina_Avenue = new RealEstate(32, "North Carolina Avenue", 300, 200, new int []{26,52,130,390,900,1100,1275}, 7);
		squares[32] = North_Carolina_Avenue;
		Square commChest3 = new Square(33, "Community Chest");
		squares[33] = commChest3;
		RealEstate Pennsylvania_Avenue = new RealEstate(34, "Pennsylvania Avenue", 320, 200, new int []{28,56,150,450,1000,1200,1400}, 7);
		squares[34] = Pennsylvania_Avenue;
		RailroadsAndUtilities Short_Line = new RailroadsAndUtilities(35, "Short Line", 200);
		squares[35] = Short_Line;
		Square chance3 = new Square(36, "Chance");
		squares[36] = chance3;
		RealEstate Park_Place = new RealEstate(37, "Park Place", 350, 200, new int []{35,70,175,500,1100,1300,1500}, 8);
		squares[37] = Park_Place;
		Tax Luxury_Tax = new Tax(38, "Luxury Tax");
		squares[38] = Luxury_Tax;
		RealEstate Boardwalk = new RealEstate(39, "Boardwalk", 400, 200, new int []{50,100,200,600,1400,1700,2000}, 8);
		squares[39] = Boardwalk;
		//Need to Add Jail Spot
		Jail jail = new Jail(40, "Jail");
		squares[40] = jail;
		//Add players to the array
		//Start timer call gamePlay to initiate play
	}
	
	//Iterate through players for turns. After Each Player check timer.
	private void gamePlay(){
		int player_turn = 0;
		while(true){
			//checktime();
			//check if in jail
			//if not run turn process.
			//if so run jail process.
			playerTurnProcess(players[player_turn]);
			player_turn = (player_turn+1)%players.length;
		}
	}
	
	//This turn process will be for non Jailed players. Jailed players have a different process. 
	private void playerTurnProcess(Player Curr_Play){
		//Do once then only repeat for doubles.
		do{
			dice.Roll();
			//Check for 3 doubles. If 3 go to jail and end turn.
			if(dice.getNumberOfDoublesRolled() == 3){
				Curr_Play.setCurrentSquare(-1);
				break;
			}
			int oldSquare = Curr_Play.getCurrentSquare();
			int newSquare = oldSquare + dice.getSum();
			if(newSquare>=40){
				Curr_Play.increaseBalance(200);
				newSquare = newSquare%40;
			}
			Curr_Play.setCurrentSquare(newSquare);
			//ResolveSquare(); -- Unbuilt Method to determine what happens to the player i.e. pay,buy,auction.
			//Now buy/sell houses or trade properties. 
		}while(dice.isDouble());
	}
	
	//The turn a player takes if they are in jail
	private void playerJailTurnProcess(Player Curr_Play){
		//Give option to pay 50 dollars
		//if pay then call player turn process. 
		//else roll.
		//if roll is double take turn do not roll again. 
		//if not double check if third turn
		//if third turn by 50 and move.
		//if not third turn end turn.
	}
	
	//when a player lands on a square this method will resolve all actions.
	private void resolveSquare(Player Curr_Player, int squareID){
		Square Curr_Square = getSquare(squareID);
		//How do we tell what each square is?
		//If RealEstate
			//is owned? - pay rent
				//square resolved
			//unowned - Do you want to buy?
				//If bought change owner square resolved
			//If unbought - auction sequence
		//if go to jail then update player location to jail and end turn
		//if tax pay tax.
	}
	
	
	
}
