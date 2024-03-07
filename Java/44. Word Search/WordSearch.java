/***************************************************************************************************** 
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.

 ******************************************************************************************************/


class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        // for(int i=0; i<visited.length; i++){
        //     Arrays.fill(visited[i], false);
        // }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board, word, 0, visited, i, j, board.length, board[0].length)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int curIndex,  boolean[][] visited, int r, int c, int ROW, int COL){
        if(curIndex==word.length()) return true;

        if(r<0 || c<0 || r>=ROW || c>=COL || visited[r][c] || board[r][c]!=word.charAt(curIndex)) return false;

        visited[r][c] = true;

        boolean res = dfs(board, word, curIndex+1, visited, r-1, c, ROW, COL) || dfs(board, word, curIndex+1, visited, r, c-1, ROW, COL) || dfs(board, word, curIndex+1, visited, r+1, c, ROW, COL) || dfs(board, word, curIndex+1, visited, r, c+1, ROW, COL);

        visited[r][c] = false;

        return res;
    }
}
