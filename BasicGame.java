package TicTacToe;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.security.auth.Refreshable;

public class BasicGame {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ask for game choice: 3x3 or Nine-board
//		String gameChoice=askGame();
//		while(true) {
//			if(gameChoice.equals("1")) {
//				//Basic 3x3
//				//ask for opponent: random, minimax, minimax with alpha-beta prune, h-minimax with alpha-beta prune
//				String opponentChoice=askOpponent();
//				while(true) { //在这里可以变化AI的对应几行
//					if(opponentChoice.equals("1")) {
//						System.out.println("random");
//						break;
//					}else if(opponentChoice.equals("2")) {
//						System.out.println("minimax");
//						break;
//					}else if(opponentChoice.equals("3")) {
//						System.out.println("minimax with alpha-beta prune");
//						break;
//					}else if(opponentChoice.equals("4")) {
//						System.out.println("h-minimax with alpha-beta prune");
//						break;
//					}else {
//						System.out.println("Wrong Input! Please select 1-4.");
//					}
//				}
//				break;
//			}else if(gameChoice.equals("2")) {
//				//Nine-Board
//				break;
//			}else {
//				System.out.println("Wrong Input! Please select 1 or 2.");
//			}
//		}
//		
		
		GameRule.displayBoard(Board.gameBoard);
		String[] gameBoard=Board.gameBoard;
//		askLocation();
		
	
		Scanner scan = new Scanner(System.in);	
				String playerMark = null;
				String AIMark = null;
				String whoIsX = null;
				while(true) {
					System.out.println("Do you want to play X or O?");
					String mark = scan.next();
				
					if (mark.equals("x")||mark.equals("X")) {
						playerMark="X";
						AIMark="O";
						whoIsX = "player";
						break;
					}else if (mark.equals("o")||mark.equals("O")) {
						playerMark="O";
						AIMark="X";
						whoIsX = "AI";
						break;
					}else {
						System.out.println("Wrong Input!");
					}	
				}		
			
		
		while(true) {
			if (whoIsX.equals("player")) {	//player mark: X
				//Player: Move
				System.out.println("Your move [col row]?");
				String playerPosition = scan.next();
				while(GameRule.allPositionStrings.contains(playerPosition)) {
					System.out.println("Place taken. Choose another move [col row]:");
					playerPosition = scan.next();
				}
				System.out.println("X@"+playerPosition);
				GameRule.refreshBoard(gameBoard,playerPosition, playerMark,"player");
				//Player: Check Winner
				String result=GameRule.checkWinner(gameBoard, "player");		
				if(result.length()>0) {
					System.out.println(result);
					break;
				}
				
				//AI: move 
				Random random = new Random();
//				String[] colnList = {"a","b","c"};
//				String[] rowList = {"1","2","3"}; 
//				String AIposition = colnList[random.nextInt(colnList.length)]+rowList[random.nextInt(rowList.length)];
//				while(GameRule.allPositionStrings.contains(AIposition)) {
////					System.out.println(AIposition);
//					AIposition = colnList[random.nextInt(colnList.length)]+rowList[random.nextInt(rowList.length)];
//				}
				String AIposition=Minimax.translate(Minimax.minimax(gameBoard,2,"player","AI")[0]);
				System.out.println(Minimax.minimax(gameBoard,2,"player","AI")[0]+"   "+Minimax.minimax(gameBoard,2,"player","AI")[1]);
				System.out.println("O@"+AIposition);
				GameRule.refreshBoard(gameBoard,AIposition, AIMark,"AI");
				//AI: Check winner
				result=GameRule.checkWinner(gameBoard, "player");		
				if(result.length()>0) {
					System.out.println(result);
					break;
				}
//				System.out.println("all:"+allPositionStrings);
//				System.out.println("ply:"+playerPositionStrings);
//				System.out.println("AI:"+AIPositionStrings);

				

			}else {
				//AI: move 
				Random random = new Random();
				String[] colnList = {"a","b","c"};
				String[] rowList = {"1","2","3"}; 
				String AIposition = colnList[random.nextInt(colnList.length)]+rowList[random.nextInt(rowList.length)];
				while(GameRule.allPositionStrings.contains(AIposition)) {
//					System.out.println(AIposition);
					AIposition = colnList[random.nextInt(colnList.length)]+rowList[random.nextInt(rowList.length)];
				}
				System.out.println("X@"+AIposition);
				GameRule.refreshBoard(gameBoard,AIposition, AIMark,"AI");
				//AI: Check Winner
				String result=GameRule.checkWinner(gameBoard,"AI");
				if(result.length()>0) {
					System.out.println(result);
					break;
				}	
				
				//Player: Move
				System.out.println("Your move [col row]?");
				String playerPosition = scan.next();
				while(GameRule.allPositionStrings.contains(playerPosition)) {
					System.out.println("Place taken. Choose another move [col row]:");
					playerPosition = scan.next();
				}
				System.out.println("O@"+playerPosition);
				GameRule.refreshBoard(gameBoard,playerPosition, playerMark,"player");
				
				//Player: Check Winner
				result=GameRule.checkWinner(gameBoard, "AI");		
				if(result.length()>0) {
					System.out.println(result);
					break;
				}
//				System.out.println(allPositionStrings);
//				System.out.println(playerPositionStrings);
//				System.out.println(AIPositionStrings);

			}
		}



	}


		

	
	public static String askGame() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Tic-Tac-Toe by Minghui Cen and Ruwei Chen\n"
				+ "Choose your game:\n"
				+ "1. Basic 3x3 Tic-Tac-Toe\n"
				+ "2. Nine-board Tic-Tac-Toe\n"
				+ "Your choice?");
		String gameChoice = scan.next();
		return gameChoice;
		
	}
	
	public static String askOpponent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose your opponent:\n"
				+ "1. An agent that plays randomly\n"
				+ "2. An agent that uses MINIMAX\n"
				+ "3. An agent that uses MINIMAX with alpha-beta pruning\n"
				+ "4. An agent that uses H-MINIMAX with alpha-beta and a fixed depth cutoff\n"
				+ "Your choice?");
		String opponentChoice=scan.next();
		return opponentChoice;
		
	}
	

		

}
