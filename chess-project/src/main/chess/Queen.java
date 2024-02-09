package chess;

public class Queen extends Piece{
	private PieceColour colour;
	private String symbol;

	public Queen(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♕";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♛";
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
		if ((Math.abs(i1-i0)==0 || Math.abs(j1-j0)==0) && !(i0==i1 && j0==j1)){
			
			if (Math.abs(i1-i0)==0){
				
				int delta = (j1-j0>0 ? (int)1 : -1);
				for (int j = j0; j!=j1; j = j + delta ){
					if (Board.getPiece(i0, j)!=null && j!=j1 && j!=j0){
			
						return false;
					}
				}

			}
			else{

				int delta = (i1-i0>0 ? (int)1 : -1);
				for (int i = i0; i!=i1; i = i + delta ){
					if (Board.getPiece(i, j0)!=null && i!=i1 && i!=i0){
						return false;
					}
				}
			}

			if ((Board.getPiece(i1, j1)==null || Board.getPiece(i1, j1).getColour()!=colour)){
				return true;
			}
		else {return false;}

		}else if ((Math.abs(i1-i0)!=0 || Math.abs(j1-j0)!=0) && !(i0==i1 && j0==j1) && Math.abs(i1-i0)==Math.abs(j1-j0)){
			int deltaj = (j1-j0>0 ? (int)1 : -1);
			int deltai = (i1-i0>0 ? (int)1 : -1);
			int i = i0 + deltai;
			int j = j0 + deltaj;
			while (i!=i1 && j!=j1){
				if (Board.getPiece(i, j)!=null){
					return false;
				}
				i = i + deltai;
				j = j + deltaj;
			}
			if (Board.getPiece(i1, j1)==null || Board.getPiece(i1, j1).getColour()!=colour){
				return true;
			}
			else return false;
			
			
		}
		else{
			return false;
		}
	}
}
