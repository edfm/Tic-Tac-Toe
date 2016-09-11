package com.efalone.tictactoe;
import java.util.Scanner;

public class Game {
	
	private Scanner scan;
	private int row, col = 0;
	private char[][] board = new char[3][3];
	private char turn = 'X';
	private boolean playing;
	
	public Game(){
		for (int i = 0; i < board.length; i++) {
			for(int j = 0;j < board[i].length; j++){
				board[i][j] = '_';
			}
		}
	}
	
	public void play(){
		playing = true;
		
		scan = new Scanner(System.in);
		
		while(playing){
			
			printBoard();
			
			if(turn == 'X'){
				System.out.println("\nPlayer \"X\" select the row");
				row = scan.nextInt() - 1;
				System.out.println("now the column");
				col = scan.nextInt() - 1;
			} else {
				System.out.println("\nPlayer \"O\" select the row");
				row = scan.nextInt() - 1;
				System.out.println("now the column");
				col = scan.nextInt() - 1;	
			}
			
			board[row][col] = turn;
			
			if(isGameOver(row,col)){
				printBoard();
				System.out.println("Player " + turn + " wins!");
				playing = false;
			}
			
			if(turn == 'X')
				turn = 'O';
			else 
				turn = 'X';
			
					
		}
	}
	
	private boolean isGameOver(int r, int c){
		
		if(board[0][c] == board[1][c] && board[0][c] == board[2][c])
			return true;
		if(board[r][0] == board[r][1] && board[r][0] == board[r][2])
			return true;
		if(board[0][0] != '_' && board[1][1] != '_' && board[2][2] != '_')
			return true;
		if(board[2][0] != '_' && board[1][1] != '_' && board[0][2] != '_')
			return true;
		
		return false;
	}
	
	private void printBoard(){
		for (int i = 0; i < board.length; i++) {
			System.out.print("| ");
			for(int j = 0; j < board[i].length; j++){
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
		}
	}
}
