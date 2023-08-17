/*

src - https://leetcode.com/problems/01-matrix/description/

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.

*/


class BFSMatrix{
    public int[][] updateMatrix(int[][] mat) {
       
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> bfs = new LinkedList<>();
    
         for(int i = 0; i < m; i++) {
            for(int j = 0; j < n ; j++) {

                  if( mat[i][j] != 0) {
                      mat[i][j] = -1;
                  } else {
                      //IMP - if the shortest distance has to be found from zero, then start from all the zeros.
                      bfs.add(new int[]{i,j});
                  }
            }
        }

        int[] directionX = {1, -1, 0, 0};
        int[] directionY = {0, 0, 1, -1};

        int pathLength = 0;
        
        while(!bfs.isEmpty()) {

            int[] arr = bfs.poll(); 
            
            int x = arr[0];
            int y = arr[1];

            for(int i = 0; i < 4; i++) {
                int newRow = x + directionX[i];
                int newCol = y + directionY[i];

                if(newRow < 0 || newCol < 0 || newRow >= mat.length || newCol >= mat[0].length || mat[newRow][newCol] >= 0 ) {
                    continue;
                } else {
                    mat[newRow][newCol] = mat[x][y] + 1 ;
                }
                // IMP : Independet of it's value enqueue the element, because adjacent of that can be -1
                bfs.add(new int[]{newRow,newCol});
            }
        }
        // using the same matrix 'mat' to save on memory
        return mat;
    }
}