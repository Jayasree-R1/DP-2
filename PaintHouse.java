//TC : O(m)
//SC : O(m*n)
// Approach:0: (to store the path)

import java.util.Arrays;

class Solution {
    public int minCost(int[][] costs) {

        int m = costs.length;
        int n = costs[0].length;

        int[][] dp = new int[m][n];   
        int[][] path = new int[m][n];

        //Filling last row of 2D DP matrix - Bottom up approach
        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];

        //Go over DP matrix
        for(int i=m-2; i>=0; i--){
            if(dp[i+1][1] < dp[i+1][2]){
                path[i][0] = 1;
            }else{
                path[i][0] = 2;
            }

             if(dp[i+1][0] < dp[i+1][2]){
                path[i][1] = 0;
            }else{
                path[i][1] = 2;
            }

             if(dp[i+1][0] < dp[i+1][1]){
                path[i][2] = 0;
            }else{
                path[i][2] = 1;
            }

            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        System.out.println(Arrays.deepToString(path));

        int idx = 0;
        if(dp[0][0]< dp[0][1] && dp[0][0]<dp[0][2]){
            idx = 0;
        }else if(dp[0][1]< dp[0][0] && dp[0][1]<dp[0][2]){
            idx = 1;
        } else{
            idx = 2;
        }
        int i = 0;
        while(i<m){
            System.out.println(idx);
            idx = path[i][idx];
            i++;
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2])); 
    }
}

// // Approach 1: (using DP Array instead of 2D Matrix)
// class Solution {
//     public int minCost(int[][] costs) {

//         int m = costs.length;
//         int n = costs[0].length;

//         // int[][] dp = new int[m][n];   

//         //Filling last row of 2D DP matrix - Bottom up approach
//         int colorR = costs[m-1][0];
//         int colorB = costs[m-1][1];
//         int colorG = costs[m-1][2];

//         //Go over DP matrix
//         for(int i=m-2; i>=0; i--){

//             int tempR = colorR;
//             int tempB = colorB;

//             colorR = costs[i][0] + Math.min(colorB, colorG);
//             colorB = costs[i][1] + Math.min(tempR, colorG);
//             colorG = costs[i][2] + Math.min(tempR, tempB);
//         }
//         return Math.min(colorR, Math.min(colorB, colorG)); 
//     }
// }

// // //Approach 2: (DP 2D Matrix) - Top Down
// class Solution {
//     public int minCost(int[][] costs) {

//         int m = costs.length;
//         int n = costs[0].length;

//         int[][] dp = new int[m][n];   

//         //Filling last row of 2D DP matrix - Bottom up approach
//         dp[0][0] = costs[0][0];
//         dp[0][1] = costs[0][1];
//         dp[0][2] = costs[0][2];

//         //Go over DP matrix
//         for(int i=1; i<m; i++){
//             dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
//             dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
//             dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
//         }
//         return Math.min(dp[m-1][0], Math.min(dp[m-1][1], dp[m-1][2])); 
//     }
// }
// //Approach 2: (DP 2D Matrix) - Bottom up
// class Solution {
//     public int minCost(int[][] costs) {

//         int m = costs.length;
//         int n = costs[0].length;

//         int[][] dp = new int[m][n];   

//         //Filling last row of 2D DP matrix - Bottom up approach
//         dp[m-1][0] = costs[m-1][0];
//         dp[m-1][1] = costs[m-1][1];
//         dp[m-1][2] = costs[m-1][2];

//         //Go over DP matrix
//         for(int i=m-2; i>=0; i--){
//             dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
//             dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
//             dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
//         }
//         return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2])); 
//     }
// }
//Approach1 : Time limit exceeds (Grredy/Exhaustion)
// class Solution {
//     public int minCost(int[][] costs) {
   
    //    int colorR = helper(costs,0,0,0);
    //    int colorB = helper(costs,0,1,0);
    //    int colorG = helper(costs,0,2,0);

    //    return Math.min(colorR,Math.min(colorB,colorG));
    // }
    // private int helper(int[][] costs, int i, int color, int totalCost){
    //     //base case
    //     if(costs.length){
    //         return totalCost;
    //     }

    //     if(color == 0){
    //         return Math.min(helper(costs,i+1,1,totalCost + costs[i][0]),
    //                         helper(costs,i+1,2,totalCost + costs[i][0]));
    //     } else if(color == 1){
    //         return Math.min(helper(costs,i+1,0,totalCost + costs[i][1]),
    //                         helper(costs,i+1,1,totalCost + costs[i][1]));
    //     } else if(color == 2){
    //         return Math.min(helper(costs,i+1,1,totalCost + costs[i][2]),
    //                         helper(costs,i+1,0,totalCost + costs[i][2]));
    //     }

    //     return -1;
    // }



// }