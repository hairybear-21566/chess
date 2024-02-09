package chess;

public class Pawn extends Piece{
	private PieceColour colour;
	private String symbol;

	public Pawn(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♙";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♟";
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
		int delta = colour==PieceColour.WHITE ? (int)-1 : (int)1;
		int istart = colour==PieceColour.WHITE ? 6 : (int)1;
		
		if ((i1-i0==delta)&& (j0==j1) && Board.hasPiece(i1, j1)==false){
			return true;
		}else if ((i1-i0==delta)&& (Math.abs(j1-j0)==1) && Board.hasPiece(i1, j1)==true && Board.getPiece(i1,j1).getColour()!=colour){
			return true;
		}
		else if ((i1-i0==delta*2)&& (j0==j1) && (i0 == istart) && Board.hasPiece((int)(i1+i0)/2, (int)(j1+j0)/2)==false && Board.hasPiece(i1, j1)==false){
			return true;
		}
		return false;
	}
	
}
