package TicTacToe;

import java.util.ArrayList;

public class Board {
	protected static String[] gameBoard={"  ","a","   ","b","   ","c",		// 1-a, 3-b, 5-c
			  "1 "," "," | "," "," | "," ",	// 6-1, 7-a1, 9-b1, 11-c1
			" ---+---+---",
			  "2 "," "," | "," "," | "," ",	//13-2, 14-a2, 16-b2, 18-c2
		     " ---+---+---",
		      "3 "," "," | "," "," | "," "};	//20-3, 21-a3, 23-b3, 25-c3
	
	public Board(String[] gameBoard) {
		
		this.gameBoard=gameBoard;
	}
}
