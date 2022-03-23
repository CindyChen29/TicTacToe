package TicTacToe;

import java.awt.Container;
import java.util.*;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Minimax {
	
	
	static String[] gameBoard=Board.gameBoard;
	 
//	public Minimax(int d, String user) {
//		this.level=level;
//		this.user=user;
//	}
	
	public static int[] minimax(String[] gameBoard,int depth, String whoIsX, String currentUser) {
		String[] tempBoard = {gameBoard[7],gameBoard[9],gameBoard[11],
			  gameBoard[14],gameBoard[16],gameBoard[18],
			  gameBoard[21],gameBoard[23],gameBoard[25]};
		
		List<Integer> nextMoves=generateMoves(gameBoard,whoIsX);
		int bestScore;
		if(currentUser.equals("player")) {
			bestScore=Integer.MAX_VALUE;
		}else {
			bestScore=Integer.MIN_VALUE;
		}
		int currentScore;
		int bestIndex=-1;
		int[] output= {bestIndex, bestScore};
		
		if(nextMoves.isEmpty()||depth == 0) {
			bestScore=evaluate(tempBoard, whoIsX);
			System.out.println("leaf!!!!!");
		}else {
			for(int move: nextMoves) {
				if(whoIsX.equals("AI")) {
					tempBoard[move]="X";
				}else {
					tempBoard[move]="O";
				}
				if(currentUser.equals("AI")) {
					currentScore=minimax(tempBoard, depth-1, whoIsX, "player")[1];
					if(currentScore>bestScore) {
						bestScore=currentScore;
						bestIndex=move;
					}
				}else {
					currentScore=minimax(tempBoard, depth-1, whoIsX, "AI")[1];
					if(currentScore<bestScore) {
						bestScore=currentScore;
						bestIndex=move;
					}
				}
				tempBoard[move]=" ";
			}
		}
		return output;
	}
	

	   public static ArrayList<Integer> generateMoves(String[] gameBoard, String whoIsX) {
		   String[] tempBoard = {gameBoard[7],gameBoard[9],gameBoard[11],
					  gameBoard[14],gameBoard[16],gameBoard[18],
					  gameBoard[21],gameBoard[23],gameBoard[25]};
		   
		      ArrayList<Integer> nextMoves = new ArrayList<Integer>(); // allocate List
		      String[] status= {"player","AI","Tie"}; 
		      // If gameover, i.e., no next move
		      if (Arrays.asList(status).contains(GameRule.checkWinner(Board.gameBoard, "player"))||Arrays.asList(status).contains(GameRule.checkWinner(Board.gameBoard, "AI"))) {
		         return nextMoves;   // return empty list
		      }
		 
		      // Search for empty cells and add to the List
		      for (int index = 0; index<9; index++) {
		    	  	String currentString=tempBoard[index];
		            if (currentString.equals(' ')) { //??????
		               nextMoves.add(index);
		            }
		         
		      }
		      return nextMoves;
		   }
	
	   public static int evaluate(String[] tempBoard, String whoIsX) {
		   int score=0;
		   
		   if(whoIsX.equals("player")) {
			    for(int i=0;i<9;i++) {
			    	//3 rows
			    	if(tempBoard[0]==tempBoard[1]&&tempBoard[1]==tempBoard[2]) {
			    		if(tempBoard[0]=="X") {
			    			score-=10;
			    		}else {
			    			score+=10;
			    		}
			    	}
			    	if(tempBoard[3]==tempBoard[4]&&tempBoard[4]==tempBoard[5]) {
			    		if(tempBoard[3]=="X") {
			    			score-=10;
			    		}else {
			    			score+=10;
			    		}
			    	}
			    	if(tempBoard[6]==tempBoard[7]&&tempBoard[7]==tempBoard[8]) {
			    		if(tempBoard[6]=="X") {
			    			score-=10;
			    		}else {
			    			score+=10;
			    		}
			    	}
			    	System.out.println(score);

			    	//3 columns
			    	if(tempBoard[0]==tempBoard[3]&&tempBoard[3]==tempBoard[6]) {
			    		if(tempBoard[0]=="X") {
			    			score-=10;
			    		}else {
			    			score+=10;
			    		}
			    	}
			    	if(tempBoard[1]==tempBoard[4]&&tempBoard[4]==tempBoard[7]) {
			    		if(tempBoard[1]=="X") {
			    			score-=10;
			    		}else {
			    			score+=10;
			    		}
			    	}
			    	if(tempBoard[2]==tempBoard[5]&&tempBoard[5]==tempBoard[8]) {
			    		if(tempBoard[2]=="X") {
			    			score-=10;
			    		}else {
			    			score+=10;
			    		}
			    	}
			    	
			    	System.out.println(score);

			    	//2 diagonals
			    	if(tempBoard[0]==tempBoard[4]&&tempBoard[4]==tempBoard[8]) {
			    		if(tempBoard[0]=="X") {
			    			score-=10;
			    		}else {
			    			score+=10;
			    		}
			    	}
			    	if(tempBoard[2]==tempBoard[4]&&tempBoard[4]==tempBoard[6]) {
			    		if(tempBoard[2]=="X") {
			    			score-=10;
			    		}else {
			    			score+=10;
			    		}
			    	}
			
			    	System.out.println(score);

			    }
		   }else {
			   if(whoIsX.equals("player")) {
				    for(int i=0;i<9;i++) {
				    	//3 rows
				    	if(tempBoard[0]==tempBoard[1]&&tempBoard[1]==tempBoard[2]) {
				    		if(tempBoard[0]=="O") {
				    			score-=10;
				    		}else {
				    			score+=10;
				    		}
				    	}
				    	if(tempBoard[3]==tempBoard[4]&&tempBoard[4]==tempBoard[5]) {
				    		if(tempBoard[3]=="O") {
				    			score-=10;
				    		}else {
				    			score+=10;
				    		}
				    	}
				    	if(tempBoard[6]==tempBoard[7]&&tempBoard[7]==tempBoard[8]) {
				    		if(tempBoard[6]=="O") {
				    			score-=10;
				    		}else {
				    			score+=10;
				    		}
				    	}
				    	
				    	//3 columns
				    	if(tempBoard[0]==tempBoard[3]&&tempBoard[3]==tempBoard[6]) {
				    		if(tempBoard[0]=="O") {
				    			score-=10;
				    		}else {
				    			score+=10;
				    		}
				    	}
				    	if(tempBoard[1]==tempBoard[4]&&tempBoard[4]==tempBoard[7]) {
				    		if(tempBoard[1]=="O") {
				    			score-=10;
				    		}else {
				    			score+=10;
				    		}
				    	}
				    	if(tempBoard[2]==tempBoard[5]&&tempBoard[5]==tempBoard[8]) {
				    		if(tempBoard[2]=="O") {
				    			score-=10;
				    		}else {
				    			score+=10;
				    		}
				    	}
				    	
				    	//2 diagonals
				    	if(tempBoard[0]==tempBoard[4]&&tempBoard[4]==tempBoard[8]) {
				    		if(tempBoard[0]=="O") {
				    			score-=10;
				    		}else {
				    			score+=10;
				    		}
				    	}
				    	if(tempBoard[2]==tempBoard[4]&&tempBoard[4]==tempBoard[6]) {
				    		if(tempBoard[2]=="O") {
				    			score-=10;
				    		}else {
				    			score+=10;
				    		}
				    	}
				    }
			   }
		   }
		   return score;
	   }
	
	
	   public static String translate(int bestMove) {
		   String bestMoveString=null;
		   switch (bestMove) {
				case 0:
					bestMoveString="a1";
					break;
				case 1:
					bestMoveString="b1";
					break;
				case 2:
					bestMoveString="c1";
					break;
				case 3:
					bestMoveString="a2";
					break;
				case 4:
					bestMoveString="b2";
					break;
				case 5:
					bestMoveString="c2";
					break;
				case 6:
					bestMoveString="a3";
					break;
				case 7:
					bestMoveString="b3";
					break;
				case 8:
					bestMoveString="c3";
					break;
				default:
					break;
		}
		return bestMoveString;
	   }

}
