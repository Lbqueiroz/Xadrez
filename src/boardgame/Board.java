package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getCollumn()];
	}
	
	public void placePiece(Piece piece, Position pos) {
		if (thereIsAPiece(pos)) {
			throw new BoardException("There is already a piece on position " + pos);
		}
		pieces[pos.getRow()][pos.getCollumn()] = piece;
		piece.position = pos;
	}
	
	public Piece removePiece(Position pos) {
		if(!positionExists(pos)) {
			throw new BoardException("Position not on the board");
		}
		if(piece(pos) == null) {
			return null;
		}
		Piece aux = piece(pos);
		aux.position = null;
		pieces[pos.getRow()][pos.getCollumn()] = null;
		return aux;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position pos) {
		return positionExists(pos.getRow(), pos.getCollumn());
	}
	
	public boolean thereIsAPiece(Position pos) {
		if (!positionExists(pos)) {
			throw new BoardException("Position not on the board");
		}
		return piece(pos) != null;
	}
	
	
}
