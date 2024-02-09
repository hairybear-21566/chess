package chess;

import java.io.Console;

public class Game {
	private static boolean gameEnd=false;

	public static void play() {
		boolean whitesTurn = true;
		Console input = System.console();

		while (!gameEnd){
				if (whitesTurn){
					System.out.println("");
					System.out.println("------ Whites move -------");
				}
				else{
					System.out.println("");
					System.out.println("------ Blacks move -------");
				}
				boolean correctOrigin=false;
				boolean correctDestination=false;

				Piece p=null;
				int i0=0,j0=0,i1=0,j1=0;
				while (!correctOrigin && !correctDestination){
					while (!correctOrigin){
						System.out.println("> Enter origin:");
						String origin = input.readLine();
						if (origin.equals("END")){
							gameEnd=true;
							break;
						}
						correctOrigin=CheckInput.checkCoordinateValidity(origin);
						if (correctOrigin){
							i0=getI(origin.charAt(0))-1;
							j0=getJ(origin.charAt(1))-1;
							if (Board.hasPiece(i0, j0)){
								//Check the colour
								if (whitesTurn && Board.getPiece(i0, j0).getColour()==PieceColour.WHITE)
									p=Board.getPiece(i0, j0);
								else if (!whitesTurn && Board.getPiece(i0, j0).getColour()==PieceColour.BLACK)
									p=Board.getPiece(i0, j0);
								else {
									//if((Board.getPiece(i0, j0).getColour()!=PieceColour.WHITE && whitesTurn) || (Board.getPiece(i0, j0).getColour()!=PieceColour.BLACK && !whitesTurn))
									correctOrigin=false;
									System.out.println("> You can only move a piece of your colour.");
								}
							}
							else{
								correctOrigin=false;
								System.out.println("> There is NO piece in this coordinate.");
							}
						}
					}
					if (gameEnd==true){
						System.out.println("Game ended");
						break;
					}
					System.out.println("> Enter destination:");
					String destination = input.readLine();
					if (destination.equals("END")){
						gameEnd=true;
						System.out.println("Game ended");
						break;
					}
					correctDestination=CheckInput.checkCoordinateValidity(destination);
					if (correctDestination){
						i1=getI(destination.charAt(0))-1;
						j1=getJ(destination.charAt(1))-1;
						// Check if movement is legal
						if (p.isLegitMove(i0,j0,i1,j1)){
							if (Board.movePiece(i0,j0,i1,j1,p)){
								if (p.getColour()==PieceColour.WHITE)
									System.out.println("WHITES WIN");
								else
									System.out.println("BLACKS WIN");
								gameEnd=true;
							}
						}
						else{
							System.out.println("Illegal move");
							correctDestination=false;
							correctOrigin=false;
						}
					}
					else{
						correctDestination=false;
						correctOrigin=false;
					}
				}
				whitesTurn=!whitesTurn;
			}
	}

	private static int getI(char row){
		int i=Character.getNumericValue(row);
		return i;
	}

	private static int getJ(char cal){
		int j=0;
		if (cal=='a')
			j=1;
		else if (cal=='b')
			j=2;
		else if (cal=='c')
			j=3;
		else if (cal=='d')
			j=4;
		else if (cal=='e')
			j=5;
		else if (cal=='f')
			j=6;
		else if (cal=='g')
			j=7;
		else if (cal=='h')
			j=8;
		return j;
	}

	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();
	}
}
