# Sudoku Solver

**Question:** 

Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character `'.'`.

A sudoku solution must satisfy **all of the following rules**:

1. Each of the digits `1-9` must occur exactly once in each row.
2. Each of the digits `1-9` must occur exactly once in each column.
3. Each of the the digits `1-9` must occur exactly once in each of the 9 `3x3` sub-boxes of the grid.

**Example:** 

```
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output:
[
    [5, 3, 4, 6, 7, 8, 9, 1, 2],
    [6, 7, 2, 1, 9, 5, 3, 4, 8],
    [1, 9, 8, 3, 4, 2, 5, 6, 7],
    [8, 5, 9, 7, 6, 1, 4, 2, 3],
    [4, 2, 6, 8, 5, 3, 7, 9, 1],
    [7, 1, 3, 9, 2, 4, 8, 5, 6],
    [9, 6, 1, 5, 3, 7, 2, 8, 4],
    [2, 8, 7, 4, 1, 9, 6, 3, 5],
    [3, 4, 5, 2, 8, 6, 1, 7, 9]
]
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/SodukuSolver.java)] 

```java
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
```

Time Complexity: ***O*(81n<sup>2</sup>)** 

Space Complexity: ***O*(1)** 

*Note:* 

- Backtracking:  A general algorithm for finding all (or some) solutions to some computational problems, notably constraint satisfaction problems, that incrementally builds candidates to the solutions, and abandons a candidate ("backtracks") as soon as it determines that the candidate cannot possibly be completed to a valid solution.