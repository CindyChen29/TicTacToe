package TicTacToe;

import java.util.*;

public class GameRule {
	static ArrayList<String> playerPositionStrings = new ArrayList<String>();
	static ArrayList<String> AIPositionStrings = new ArrayList<String>();
	static ArrayList<String> allPositionStrings = new ArrayList<String>();
		
	public GameRule(ArrayList<String> playerPositionStrings,ArrayList<String> AIPositionStrings,ArrayList<String> allPositionStrings) {
		this.playerPositionStrings=playerPositionStrings;
		this.AIPositionStrings=AIPositionStrings;
		this.allPositionStrings=allPositionStrings;
	}

	public static String checkWinner(String[] gameBoard, String whoIsX) {
		String[] tempBoard = {gameBoard[7],gameBoard[9],gameBoard[11],
							  gameBoard[14],gameBoard[16],gameBoard[18],
							  gameBoard[21],gameBoard[23],gameBoard[25]};
		String result = null;
		for(int i=0; i<8; i++) {
			String output = null;

			switch(i){	//to check if any 
				case 0:
					output = tempBoard[0]+tempBoard[1]+tempBoard[2];
					break;
				case 1:
					output = tempBoard[3]+tempBoard[4]+tempBoard[5];
					break;
				case 2:
					output = tempBoard[6]+tempBoard[7]+tempBoard[8];
					break;
				case 3:
					output = tempBoard[0]+tempBoard[3]+tempBoard[6];
					break;
				case 4:
					output = tempBoard[1]+tempBoard[4]+tempBoard[7];
					break;
				case 5:
					output = tempBoard[2]+tempBoard[5]+tempBoard[8];
					break;
				case 6:
					output = tempBoard[0]+tempBoard[4]+tempBoard[8];
					break;
				case 7:
					output = tempBoard[2]+tempBoard[4]+tempBoard[6];
					break;
			}		
			
			if (whoIsX.equals("player")) {
				if(output.equals("XXX")){
					result="player";
					break;
				}else if(output.equals("OOO")) {
					result= "AI";
					break;
				}else if(allPositionStrings.size() == 9){
					result="Tie";
					break;
				}else {
					result="";
				}	
			}
	
			if (whoIsX.equals("AI")) {
				if(output.equals("OOO")){
					result="AI";
					break;
				}else if(output.equals("XXX")) {
					result= "player";
					break;
				}else if(allPositionStrings.size() == 9){
					result="Tie";
					break;
				}else {
					result="";
				}	
			}
		}
		return result;
	}

	public static void refreshBoard(String[] gameBoard, String location, String mark, String subject) {
		
		if (subject.equals("player")) {
			playerPositionStrings.add(location);
		}else {
			AIPositionStrings.add(location);
		}
		
		allPositionStrings.add(location);
		
		switch(location) {
			case "a1":
				gameBoard[7] = mark;
				break;
			case "b1":
				gameBoard[9] = mark;
				break;
			case "c1":
				gameBoard[11] = mark;
				break;
			case "a2":
				gameBoard[14] = mark;
				break;
			case "b2":
				gameBoard[16] = mark;
				break;
			case "c2":
				gameBoard[18] = mark;
				break;
			case "a3":
				gameBoard[21] = mark;
				break;
			case "b3":
				gameBoard[23] = mark;
				break;
			case "c3":
				gameBoard[25] = mark;
				break;
			default:
				break;
		
		}
		displayBoard(gameBoard);
	}
	public static void displayBoard(String[] gameBoard) {

		
		for (int i = 0; i < gameBoard.length; i++) {
			if (gameBoard[i].equals("1 ")||gameBoard[i].equals("2 ")||gameBoard[i].equals("3 "))  {
				System.out.println();
			}	
			if (gameBoard[i].equals(" ---+---+---")) {
				System.out.println();
			}
			System.out.print(gameBoard[i]);

		} 
		
		System.out.println();
	}
}
