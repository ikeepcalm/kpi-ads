package dev.ikeepcalm.solution;

public class Backpack {

    private final int N;
    private final int W;
    private final int[][] items;

    public Backpack(int N, int W) {
        this.N = N;
        this.W = W;
        this.items = new int[N][2];
    }

    public int calculateDynamically() {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int weight = items[i - 1][0];
            int price = items[i - 1][1];
            for (int j = 0; j <= W; j++) {
                if (weight <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + price);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int maxPrice = dp[N][W];
        int w = W;
        System.out.print("Items included in the backpack: ");
        for (int i = N; i > 0 && maxPrice > 0; i--) {
            if (maxPrice != dp[i - 1][w]) {
                System.out.print(i - 1 + " ");
                maxPrice -= items[i - 1][1];
                w -= items[i - 1][0];
            }
        }

        return dp[N][W];
    }

    public void addItem(int index, int weight, int price) {
        items[index] = new int[]{weight, price};
    }

}
