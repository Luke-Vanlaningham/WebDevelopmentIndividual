package toughPuzzles;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		//MyFrame[] myGames = new MyFrame[12];
		int[] numRows = new int[17];
		int[] numColumns = new int[17];
		int[] numMoves = new int[17];
		ArrayList<Function[]> myMovesList = new ArrayList<Function[]>();
				//Game 1 idea SOLVED EASY
				Function[] myMovesOne = new  Function[3];
				int[][] move1 = new int[][] {{1,2,3,4,9},{0,6,7,8,14},{5,11,12,13,19},{10,16,17,18,24},{15,20,21,22,23}};
				int[][] move2 = new int[][] {{0,1,2,3,4},{5,7,8,13,9},{10,6,12,18,14},{15,11,16,17,19},{20,21,22,23,24}};
				int[][] move3 = new int[][] {{0,1,2,3,4},{5,6,7,8,9},{10,11,12,14,13},{15,16,17,18,19},{20,21,22,23,24}};
				numRows[0] =  move1.length;
				numColumns[0] = move1[0].length;
				myMovesOne[0] = new Function(move1,numRows[0],numColumns[0]);
				myMovesOne[1] = new Function(move2,numRows[0],numColumns[0]);
				myMovesOne[2] = new Function(move3,numRows[0],numColumns[0]);
				myMovesList.add(myMovesOne);
				numMoves[0]= myMovesOne.length;
				
				
				//Game 2 idea SOLVED MEDIUM
				Function[] myMovesTwo = new  Function[4];
				 move1 = new int[][]{{1,4,2},{3,0,5},{6,7,8}};
				 move2 = new int[][] {{0,1,5},{3,2,4},{6,7,8}};
				 move3 = new int[][] {{0,1,2},{3,8,5},{6,4,7}};
				int[][] move4 = new int[][] {{0,1,2},{4,6,5},{3,7,8}};
				 numRows[1] = move1.length;
				 numColumns[1] = move1[0].length;
				myMovesTwo[0] = new Function(move1,numRows[1],numColumns[1]);
				myMovesTwo[1] = new Function(move2,numRows[1],numColumns[1]);
				myMovesTwo[2] = new Function(move3,numRows[1],numColumns[1]);
				myMovesTwo[3] = new Function(move4,numRows[1],numColumns[1]);
				myMovesList.add(myMovesTwo);
				numMoves[1]= myMovesTwo.length;


				
				//GAME 3 idea SOLVED HARD
				Function[] myMovesThree = new  Function[3];

				move1 = new int[][] {{1,5,3,7},{0,4,2,6},{9,13,11,15},{8,12,10,14}};
				move2 = new int[][] {{0,1,2,3},{4,6,10,7},{8,5,9,11},{12,13,14,15}};
				move3 = new int[][] {{ 3, 1, 2, 0},
											 { 7, 5, 6, 4},
											 {11, 9,10,8},
											 {15,13,14,12}};						 
				numRows[2] = move1.length;
				numColumns[2] = move1[0].length;
				myMovesThree[0] = new Function(move1,numRows[2],numColumns[2]);
				myMovesThree[1] = new Function(move2,numRows[2],numColumns[2]);
				myMovesThree[2] = new Function(move3,numRows[2],numColumns[2]);
				myMovesList.add(myMovesThree);
				numMoves[2]= myMovesThree.length;

				
				//GAME 4 idea SOLVED EASY
				Function[] myMovesFour = new  Function[3];
				 move1 = new int[][] {{1,2,3,7},
											{0,5,6,11},
											{4,9,10,15},
											{8,12,13,14}};
				 move2 = new int[][] {{0,1,2,3},
											 {4,6,10,7},
										     {8,5,9,11},
											 {12,13,14,15}};
				 move3 = new int[][] {{0,1,2,3},
											{4,5,7,6},
											{8,9,10,11},
											{12,13,14,15}};	
				 numRows[3] = move1.length;
				 numColumns[3] = move1[0].length;
				myMovesFour[0] = new Function(move1,numRows[3],numColumns[3]);
				myMovesFour[1] = new Function(move2,numRows[3],numColumns[3]);
				myMovesFour[2] = new Function(move3,numRows[3],numColumns[3]);
				myMovesList.add(myMovesFour);
				numMoves[3]= myMovesFour.length;
											
				//Game 5 idea SOLVED MEDIUM
				Function[] myMovesFive = new  Function[4];
				 move1 = new int[][] {{1,4,2},
											 {0,3,5},
											 {6,7,8}};
				 move2 = new int[][] {{0,2,5},
											 {3,1,4},
											 {6,7,8}};
				 move3 = new int[][] {{0,1,2},
										     {3,5,8},
											 {6,4,7}};
				 move4 = new int[][] {{0,1,2},
											 {4,7,5},
											 {3,6,8}};
				 numRows[4] = move1.length;
				 numColumns[4] = move1[0].length;
			    myMovesFive[0] = new Function(move1,numRows[4],numColumns[4]);
				myMovesFive[1] = new Function(move2,numRows[4],numColumns[4]);
				myMovesFive[2] = new Function(move3,numRows[4],numColumns[4]);
				myMovesFive[3] = new Function(move4,numRows[4],numColumns[4]);
				myMovesList.add(myMovesFive);
				numMoves[4]= myMovesFive.length;
				
				// Game 6 idea SOLVED EASY
				Function[] myMovesSix = new  Function[6];
				 move1 = new int[][] {{1,0,2,3,4,5,6}};
				 move2 = new int[][] {{0,2,1,3,4,5,6}};
				 move3 = new int[][] {{0,1,3,2,4,5,6}};
				 move4 = new int[][] {{0,1,2,4,3,5,6}};
				int[][] move5 = new int[][] {{0,1,2,3,5,4,6}};
				int[][] move6 = new int[][] {{0,1,2,3,4,6,5}};
				 numRows[5] = move1.length;
				 numColumns[5] = move1[0].length;
				
				myMovesSix[0] = new Function(move1,numRows[5],numColumns[5]);
				myMovesSix[1] = new Function(move2,numRows[5],numColumns[5]);
				myMovesSix[2] = new Function(move3,numRows[5],numColumns[5]);
				myMovesSix[3] = new Function(move4,numRows[5],numColumns[5]);
				myMovesSix[4] = new Function(move5,numRows[5],numColumns[5]);
				myMovesSix[5] = new Function(move6,numRows[5],numColumns[5]);
				myMovesList.add(myMovesSix);
				numMoves[5]= myMovesSix.length;
				
				//Game 7 idea SOLVED EASY
				
				Function[] myMovesSeven = new  Function[2];
				 move1 = new int[][] {{1,2,3,0,4}};
				 move2 = new int[][] {{0,1,2,4,3}};
				numRows[6] = move1.length;
				numColumns[6] = move1[0].length;
				myMovesSeven[0] = new Function(move1,numRows[6],numColumns[6]);
				myMovesSeven[1] = new Function(move2,numRows[6],numColumns[6]);
				myMovesList.add(myMovesSeven);
				numMoves[6]= myMovesSeven.length;
		
				//Game 8 idea SOLVED EASY
				Function[] myMovesEight = new  Function[2];
				 move1 = new int[][] {{1,2,0,3,4}};
				move2 = new int[][] {{0,1,3,4,2}};
				 numRows[7] = move1.length;
				numColumns[7] = move1[0].length;
				myMovesEight[0] = new Function(move1,numRows[7],numColumns[7]);
				myMovesEight[1] = new Function(move2,numRows[7],numColumns[7]);
				myMovesList.add(myMovesEight);
				numMoves[7]= myMovesEight.length;
		
				//Game 9 idea easy SOLVED EASY
				Function[] myMovesNine = new  Function[4];
				 move1 = new int[][] {{1,3},{2,0}};
				 move2 = new int[][] {{0,3},{1,2}};
				 move3 = new int[][] {{3,1},{0,2}};
				 move4 = new int[][] {{1,2},{0,3}};

				 numRows[8] = move1.length;
				 numColumns[8] = move1[0].length;
				myMovesNine[0] = new Function(move1,numRows[8],numColumns[8]);
				myMovesNine[1] = new Function(move2,numRows[8],numColumns[8]);
				myMovesNine[2] = new Function(move3,numRows[8],numColumns[8]);
				myMovesNine[3] = new Function(move4,numRows[8],numColumns[8]);
				myMovesList.add(myMovesNine);
				numMoves[8]= myMovesNine.length;
		

				//Game 10 idea Addisons 2x2 game Solved but weird
				Function[] myMovesTen = new  Function[2];
				 move1 = new int[][] {{1,2},{3,0}};
				 move2 = new int[][] {{1,3},{0,2}};
				//int[][] move3 = new int[][] {{2,3},{1,0}};
				 numRows[9] = move1.length;
				 numColumns[9] = move1[0].length;
				myMovesTen[0] = new Function(move1,numRows[9],numColumns[9]);
				myMovesTen[1] = new Function(move2,numRows[9],numColumns[9]);
				//myMoves[2] = new Function(move3,numRows,numColumns);*/
				myMovesList.add(myMovesTen);
				numMoves[9]= myMovesTen.length;

		
				//Game 11 idea rubiks cube but RU generated edges only SOLVED MEDIUM
				Function[] myMovesEleven = new Function[2];
				 move1 = new int[][] {{1,2,3,0,4,5,6}};
				 move2 = new int[][] {{0,1,2,4,5,6,3}};
				 numRows[10] = move1.length;
				 numColumns[10] = move1[0].length;
				myMovesEleven[0] = new Function(move1,numRows[10],numColumns[10]);
				myMovesEleven[1] = new Function(move2,numRows[10],numColumns[10]);
				myMovesList.add(myMovesEleven);
				numMoves[10]= myMovesEleven.length;
				//Game 12 idea
				Function[] myMovesTwelve = new Function[2];
				move1 = new int[][] {{1,2,3,4,0}};
				move2 = new int[][] {{1,3,4,2,0}};
				//int[][] move3 = new int[][] {{0,1,2,3,4}};
				 numRows[11] = move1.length;
				 numColumns[11] = move1[0].length;
				myMovesTwelve[0] = new Function(move1,numRows[11],numColumns[11]);
				myMovesTwelve[1] = new Function(move2,numRows[11],numColumns[11]);
				//myMoves[2] = new Function(move3,numRows,numColumns);*/
				myMovesList.add(myMovesTwelve);
				numMoves[11]= myMovesTwelve.length;

				//Game 13 idea
				Function[] myMovesThirteen = new Function[3];
				 move1 = new int[][] {{1,0,2,3}};
				 move2 = new int[][] {{0,2,1,3}};
				move3 = new int[][] {{0,1,3,2}};
				 move4 = new int[][] {{0,1,2,3}};
				 numRows[12] = move1.length;
				 numColumns[12] = move1[0].length;
				myMovesThirteen[0] = new Function(move1,numRows[12],numColumns[12]);
				myMovesThirteen[1] = new Function(move2,numRows[12],numColumns[12]);
				myMovesThirteen[2] = new Function(move3,numRows[12],numColumns[12]);
				myMovesList.add(myMovesThirteen);
				numMoves[12]= myMovesThirteen.length;
				
				//Game 14 idea part 2
				Function[] myMovesFourteen = new Function[6];
				 move1 = new int[][] {{1,0,2,3,4,5,6}};
				 move2 = new int[][] {{0,2,1,3,4,5,6}};
				 move3 = new int[][] {{0,1,3,2,4,5,6}};
				 move4 = new int[][] {{0,1,2,4,3,5,6}};
				 move5 = new int[][] {{0,1,2,3,5,4,6}};
				 move6 = new int[][] {{0,1,2,3,4,6,5}};
				

				numRows[13] = move1.length;
				numColumns[13] = move1[0].length;
				myMovesFourteen[0] = new Function(move1,numRows[13],numColumns[13]);
				myMovesFourteen[1] = new Function(move2,numRows[13],numColumns[13]);
				myMovesFourteen[2] = new Function(move3,numRows[13],numColumns[13]);
				myMovesFourteen[3] = new Function(move4,numRows[13],numColumns[13]);
				myMovesFourteen[4] = new Function(move5,numRows[13],numColumns[13]);
				myMovesFourteen[5] = new Function(move6,numRows[13],numColumns[13]);
				myMovesList.add(myMovesFourteen);
				numMoves[13]= myMovesFourteen.length;
				
				//Game 15 idea
				Function[] myMovesFifteen = new Function[4];
				 move1 = new int[][] {{0,7,2,3,4},
											 {1,6,11,8,9},
											 {10,5,12,13,14},
											 {15,16,17,18,19},
											 {20,21,22,23,24}};
				 move2 = new int[][] {{0,1,2,9,4},
											 {5,6,3,8,13},
											 {10,11,12,7,14},
											 {15,16,17,18,19},
											 {20,21,22,23,24}};
				 move3 = new int[][] {{0,1,2,3,4},
											 {5,6,7,8,9},
											 {10,11,12,19,14},
											 {15,16,13,18,23},
											 {20,21,22,17,24}};
				 move4 = new int[][] {{0,1,2,3,4},
											 {5,6,7,8,9},
											 {10,17,12,13,14},
											 {11,16,21,18,19},
											 {20,15,22,23,24}};
				numRows[14] = move1.length;
				numColumns[14] = move1[0].length;
				myMovesFifteen[0] = new Function(move1,numRows[14],numColumns[14]);
				myMovesFifteen[1] = new Function(move2,numRows[14],numColumns[14]);
				myMovesFifteen[2] = new Function(move3,numRows[14],numColumns[14]);
				myMovesFifteen[3] = new Function(move4,numRows[14],numColumns[14]);
				myMovesList.add(myMovesFifteen);
				numMoves[14]= myMovesFifteen.length;
				
				// Game 16 Group 1 Mathieu group M11 with 2 generators
				Function[] myMovesSixteen = new Function[2];
				 move1 = new int[][] {{1,2,3,4,5,6,7,8,9,10,0}};
				 move2 = new int[][] {{0,1,6,9,5,3,10,2,8,4,7}};
				 numRows[15] = move1.length;
				 numColumns[15] = move1[0].length;
				myMovesSixteen[0] = new Function(move1,numRows[15],numColumns[15]);
				myMovesSixteen[1] = new Function(move2,numRows[15],numColumns[15]);
				myMovesList.add(myMovesSixteen);
				numMoves[15]= myMovesSixteen.length;
				// Game 17 testing site
				Function[] myMovesSeventeen = new Function[3];
				 move1 = new int[][] {{1,4,2},{0,3,5}};
				 move2 = new int[][] {{0,2,5},{3,1,4}};
				 move3 = new int[][] {{3,1,0},{5,4,2}};

				 numRows[16] = move1.length;
				numColumns[16] = move1[0].length;
				myMovesSeventeen[0] = new Function(move1,numRows[16],numColumns[16]);
				myMovesSeventeen[1] = new Function(move2,numRows[16],numColumns[16]);
				myMovesSeventeen[2] = new Function(move3,numRows[16],numColumns[16]);
				myMovesList.add(myMovesSeventeen);
				numMoves[16]= myMovesSeventeen.length;
				/*int numMoves = myMoves.length;
				int maxWidth = 750/numColumns;
				int maxHeight = 700/numRows;
				int squareSize = Math.min(maxWidth, maxHeight);
				squareSize = 100;
				new MyFrame(squareSize, numRows,numColumns,numMoves,myMoves);*/
			
		Scanner scnr = new Scanner(System.in);
		System.out.println("Would you like to use one of our 17 preset games?(y/n)");
		int squareSize = 100;
		String preset = scnr.next();
		if(preset.equals("y"))
		{
			System.out.println("Okay, please type a number 1-17 and we will send you to the game.");
			int gameNumber = scnr.nextInt()-1;
			int mynumRows = numRows[gameNumber];
			int mynumColumns = numColumns[gameNumber];
			int mynumMoves = numMoves[gameNumber];
			Function[] myMoves = myMovesList.get(gameNumber);

			new MyFrame(squareSize,mynumRows,mynumColumns,mynumMoves, myMoves);
		}
		else if(preset.equals("n"))
		{
		System.out.println("Since you do not want to use our preset games, you can now choose the number of moves, the size or your board, and we will create random permutations for you.");
		System.out.println("\nhow many moves would you like this puzzle to be?");
		int numMovess = scnr.nextInt();
		System.out.println("How many columns would you like in the grid?");
		int numColumnss = scnr.nextInt();
		System.out.println("How many rows would you like in the grid");
		int numRowss = scnr.nextInt();
			new MyFrame(squareSize, numRowss,numColumnss,numMovess);
		}
		else 
		{
			System.out.println("you were supposed to input y or n, please restart the program.");
		}
		
		/*int squareSize=100;
		int numRows = 7;
		int numColumns = 7;
		int numMoves = 2;
		new MyFrame(squareSize, numRows,numColumns,numMoves);*/

		
	}

}
