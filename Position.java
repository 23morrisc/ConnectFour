public class Position {
	private int row, col;

	public Position(int r, int c) {
		this.row = r;
		this.col = c;
	}

	public Position() {
		row = -1;
		col = -1;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public boolean equals(Object o) {
		if (o instanceof Position) {
			Position temp = (Position)o;
			return row == temp.row && col == temp.col;
		}
		return false;
	}
}
