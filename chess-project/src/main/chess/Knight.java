package chess;

public class Knight extends Piece {
	private PieceColour colour;
	private String symbol;

	public Knight(PieceColour pc) {
		if (pc.equals(PieceColour.WHITE)) {
			this.colour = PieceColour.WHITE;
			this.symbol = "♘";
		} else if (pc.equals(PieceColour.BLACK)) {
			this.colour = PieceColour.BLACK;
			this.symbol = "♞";
		}
	}

	public String getSymbol() {
		return symbol;
	}

	public PieceColour getColour() {
		return colour;
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		if (((Math.abs(j1 - j0) == 2 && Math.abs(i1 - i0) == 1)
				|| (Math.abs(j1 - j0) == 1 && Math.abs(i1 - i0) == 2))) {
			if (Board.getPiece(i1, j1) == null) return true;
			else if (Board.getPiece(i1, j1).getColour() != colour) return false;
		}
		return false;
	}
}
