import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public boolean validSudoku(char[][] board) {
		/*
		 *  The element in set is unique,
		 *  use set to record the info of numbers in rows, columns and blocks
		 */
        Set<String> records = new HashSet<String>();
        int rows = board.length, cols = board[0].length;
        for(int i=0; i<rows; i++) {
        		for(int j=0; j<cols; j++) {
        			char element = board[i][j];
        			if(element != '.') {
        				/*
        				 * add the element information to the set,
        				 * if one of them fails, a conflict occurs
        				 * and the sodoku is invalid
        				 */
        				if(!records.add(element + "at row " + i) 
        					|| !records.add(element + "at column " + j)
        					|| !records.add(element + "at block " + i/3 + ',' + j/3)) {
        					return false;
        				}
        			}
        		}
        }
        return true;
    }
	public static void main(String[] args) {
		ValidSudoku demo = new ValidSudoku();
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
		System.out.println(demo.validSudoku(board));
		board[0][0] = '8';
		System.out.println(demo.validSudoku(board));
	}
}
