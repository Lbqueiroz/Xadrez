package boardgame;

public  class Position {
	
	private int Row;
	private int Column;
	
	public Position(int Row, int Column) {
		this.Row = Row;
		this.Column = Column;
	}
	
	public int getRow() {
		return Row;
	}

	public void setRow(int Row) {
		this.Row = Row;
	}

	public int getColumn() {
		return Column;
	}

	public void setColumn(int Column) {
		this.Column = Column;
	}
	
	public void setValues(int Row, int Column) {
		this.Row = Row;
		this.Column = Column;
	}

	@Override
	public String toString() {
		return Row + "," + Column;
	}

}
