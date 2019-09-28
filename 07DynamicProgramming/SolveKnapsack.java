import java.io.*;
import java.util.*;

public class SolveKnapsack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            int c = in.nextInt();
            int n = in.nextInt();
            int[] profits = new int[n];
            int[] weights = new int[n];
            int i = 0;
            while (i < n) {
                weights[i] = in.nextInt();
                profits[i] = in.nextInt();
                i++;
            }
            int maxProfit = solveKnapsack(profits, weights, c, n);
            System.out.println(maxProfit);
            t--;
        }    
    }
    public static int solveKnapsack(int[] profits, int[] weights, int capacity, int n) {
        return knapsackRecursive(profits, weights, capacity, 0, new int[capacity+1][n+1]);
    }
    public static int knapsackRecursive(int[] profits, int[] weights, int capacity, int index, int[][] dp) {
        if (index >= profits.length || capacity <= 0) {
            return 0;
        }
        if (dp[capacity][index] != 0) {
            return dp[capacity][index];
        }
        int profit1 = 0, profit2 = 0;
        if (weights[index] <= capacity) {
            profit1 = profits[index] + knapsackRecursive(profits, weights, capacity-weights[index], index+1, dp);
        }
        profit2 = knapsackRecursive(profits, weights, capacity, index + 1, dp);
        dp[capacity][index] = Math.max(profit1, profit2);
        return dp[capacity][index];
    }
}
