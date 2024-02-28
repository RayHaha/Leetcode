/***************************************************************************************************** 
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

 ******************************************************************************************************/


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        List<Integer> ans = new ArrayList<Integer>();
        while(left<right && top<bottom){
            for(int i=left; i<right; i++){
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i=top; i<bottom; i++){
                ans.add(matrix[i][right-1]);
            }
            right--;
            if(left>=right || top>=bottom) break;
            for(int i=right-1; i>=left; i--){
                ans.add(matrix[bottom-1][i]);
            }
            bottom--;
            for(int i=bottom-1; i>=top; i--){
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}
