public class ConnectFour implements BoardGame{
	private int[][] board; // game board for playing ConnectFour
	private int currentPlayer; // stores the current player's turn
	private Position[] winningPositions; //stores row+colum
	// coordinates when someone
// wins

	public ConnectFour() {
		newGame();
	}

	private int winner; // stores which player wins (0 == draw)
	@Override
	public void newGame() {
		board = new int[6][7];
		winningPositions = new Position[4];
		currentPlayer = 1 + (int)(Math.random()*2);
		winner = -1;
	}

	@Override
	public boolean gameOver() {
		for(int r = 5; r>=0; r--) {
			for (int c = 0; c <= 3; c++) {
				if (board[r][c] != 0 && board[r][c] == board[r][c+1] && board[r][c+1] == board[r][c+2] && board[r][c+2] == board[r][c+3] && board[r][c+3] == board[r][c+4])
					return true;
			}
		}
		for(int r = 5; r>=3; r--) {
			for (int c = 0; c <= 6; c++) {
				if (board[r][c] != 0 && board[r][c] == board[r-1][c] && board[r-1][c] == board[r-2][c] && board[r-2][c] == board[r-3][c] && board[r-3][c] == board[r-4][c])
					for(int i = r; i < r+4; i++) {
						winningPositions[i] = new Position(r, c+1);
					}
				winner = board[r][c];
					return true;
			}
		}
		return false;
	}

	@Override
	public int getWinner() {
		return currentPlayer;
	}

	@Override
	public Position[] getWinningPositions() {
		return winningPositions;
	}

	@Override
	public boolean columnFull(int column) {
		for(int r = 0; r < board.length; r++) {
			if (board[r][column]==0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void play(int column) {
		if(!columnFull(column)) {
			for (int r = 5; r >= 0; r--) {
				if(board[r][column] == 0) {
					board[r][column] = currentPlayer;
					break;
				}
			}
		}
		currentPlayer = (currentPlayer == 1) ? 2 : 1;
	}

	@Override
	public int[][] getBoard() {
		return board;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}
}
