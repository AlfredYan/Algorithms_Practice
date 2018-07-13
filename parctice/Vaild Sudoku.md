# Vaild Sudoku

**Question:** 

Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated **according to the following rules**:

1. Each row must contain the digits `1-9` without repetition.
2. Each column must contain the digits `1-9` without repetition.
3. Each of the 9 `3x3` sub-boxes of the grid must contain the digits `1-9` without repetition.
4. The Sudoku board could be partially filled, where empty cells are filled with the character `'.'`.

**Example:** 

```
// Example 1
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
Output: true
```

```
// Example 2
Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: There are two 8's in the top left 3x3 sub-box, it is invalid.
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/ValidSudoku.java)] 

```java
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
```

Time Complexity: ***O*(n<sup>2</sup>)** 

Space Complexity: ***O*(1)** 