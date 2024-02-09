package chess;

public class King extends Piece{
	private PieceColour colour;
	private String symbol;

	public King(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♔";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♚";
		}
	}
	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		if (Math.abs(i1-i0)<=1 && Math.abs(j1-j0)<=1 && !(i0==i1 && j0==j1))
			if (Board.getPiece(i1, j1)==null || Board.getPiece(i1, j1).getColour()!=colour){

				return true;
			}
			else return false;
		
		else{
			return false;
		}
	}

}
