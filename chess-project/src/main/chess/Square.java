package chess;

public class Square {
	private boolean hasPiece;
	private Piece p;


	public Piece getPiece(){
		return p;
	}

	public void setPiece(Piece pIn){
		p=pIn;
		hasPiece=true;
	}

	public void removePiece(){
		hasPiece=false;
		p=null;
	}

	public boolean hasPiece(){
		return hasPiece;
	}
}
