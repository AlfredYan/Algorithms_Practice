import java.util.Arrays;

public class SodukuSolver {

	public void sudokuSolver(char[][] board) {
		if(board == null) return;
		helper(board);
	}
	
	public boolean helper(char[][] board) {
		int rows = board.length, cols = board[0].length;
		// go through every element and fill it with a number
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(board[i][j] == '.') {
					// try every number from 1 to 9
					for(char c='1'; c<='9'; c++) {
						// when this number is valid for the soduku
						if(isValid(board, i, j, c)) {
							board[i][j] = c;
							// go to fill next element
							if(helper(board)) {
								return true;
							}
							else {
								/*
								 *  if we can not solve the sudoku with this number,
								 *  set current element back to '.' and try next number
								 */
								board[i][j] = '.'; // Backtracking
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isValid(char[][] board, int row, int col, char val) {
		for(int i=0; i<9; i++) {
			if(board[row][i] == val) return false;
			if(board[i][col] == val) return false;
			/*
			 *  The row and column divide by 3 then multiple by 3 
			 *  to go to first row and column of the block
			 */
			if(board[3*(row/3) + i/3][3*(col/3) + i%3] == val) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		SodukuSolver demo = new SodukuSolver();
		char[][] board = new char[][] { {'5','3','.','.','7','.','.','.','.'},
										{'6','.','.','1','9','5','.','.','.'},
										{'.','9','8','.','.','.','.','6','.'},
										{'8','.','.','.','6','.','.','.','3'},
										{'4','.','.','8','.','3','.','.','1'},
										{'7','.','.','.','2','.','.','.','6'},
										{'.','6','.','.','.','.','2','8','.'},
										{'.','.','.','4','1','9','.','.','5'},
										{'.','.','.','.','8','.','.','7','9'}
									};
		demo.sudokuSolver(board);
		for(int i=0; i<board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
}
