package chess;

public abstract class Piece {
	private String symbol;
	protected PieceColour colour;

	abstract boolean isLegitMove(int i0, int j0, int i1, int j1);

	public String getSymbol(){
		return symbol;
	}

	public void setSymbol(String s){
		symbol=s;
	}

	public PieceColour getColour(){
		return colour;
	}

}
