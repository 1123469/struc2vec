public class DTW {
    public static double[][] compute(double[]a, double[]b){
        // DTW(Dynamic Time Warping)
        // a fundamental implementation based on dynamic programming
        // dp[i][j] = Dist(i,j) + min{dp[i-1][j],dp[i][j-1],dp[i-1][j-1]}

        double[][] dp = new double[a.length][b.length];
        // set the boundary condition
        // the first column, dp[i][0] = Dist(i,0)+ dp[i-1][0];
        dp[0][0] = Math.abs(a[0]-b[0]);
        for(int i=1;i<a.length;i++)
//            dp[i][0] = Math.sqrt(Math.pow(i,2)+Math.pow((a[i]-b[0]),2));
            dp[i][0] = Math.abs(a[i]-b[0]);
        // the first row, dp[0][j] = Dist(0,j)+ dp[0][j-1];
        for(int j=1;j<b.length;j++)
//            dp[0][j] = Math.sqrt(Math.pow(j,2)+Math.pow((b[j]-a[0]),2));
            dp[0][j] = Math.abs(b[j]-a[0]);
        // fill up the whole dp matrix from left to right, from top to bottom
        for(int i=1;i<a.length;i++)
            for(int j=1;j<b.length;j++){
                // the minimum among the three
                double min = dp[i-1][j]>dp[i][j-1]?Math.min(dp[i][j-1],dp[i-1][j-1]):Math.min(dp[i-1][j],dp[i-1][j-1]);
                dp[i][j] = Math.abs(a[i]-b[j])+min;
            }

        return dp;
    }

    public static Integer compute(Integer[]a, Integer[]b){
        // DTW(Dynamic Time Warping)
        // a fundamental implementation based on dynamic programming
        // dp[i][j] = Dist(i,j) + min{dp[i-1][j],dp[i][j-1],dp[i-1][j-1]}
        if (a.length==0||b.length==0)
            return null;
        int[][] dp = new int[a.length][b.length];
        // set the boundary condition
        // the first column, dp[i][0] = Dist(i,0)+ dp[i-1][0];
        dp[0][0] = dist(a[0],b[0]);
        for(int i=1;i<a.length;i++)
            dp[i][0] = dist(a[i],b[0]);
        // the first row, dp[0][j] = Dist(0,j)+ dp[0][j-1];
        for(int j=1;j<b.length;j++)
            dp[0][j] = dist(b[j],a[0]);
        // fill up the whole dp matrix from left to right, from top to bottom
        for(int i=1;i<a.length;i++)
            for(int j=1;j<b.length;j++){
                // the minimum among the three
                int min = dp[i-1][j]>dp[i][j-1]?Math.min(dp[i][j-1],dp[i-1][j-1]):Math.min(dp[i-1][j],dp[i-1][j-1]);
                dp[i][j] = dist(a[i],b[j])+min;
            }

        return dp[a.length-1][b.length-1];
    }


    public static int dist(int a, int b){
        // Assume that a, b are both positive (the node degrees )
        return (Math.max(a,b)/Math.min(a,b))-1;
    }
//        public static int dist(int a, int b){
//        // Assume that a, b are both positive (the node degrees )
//        return Math.abs(a-b);
//    }

}