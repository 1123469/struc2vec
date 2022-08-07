import java.util.Arrays;

public class TestDTW {
    public static void main(String[]args){
        double[] a = {1,1,1,1,2,2,3,3,4,3,2,2,1,1,1,1};
        double[] b = {1,1,2,2,3,3,4,4,4,4,3,3,2,2,1,1};
//        double[] a={1,3,2,4,2};
//        double[]b ={0,3,4,2,2};
        double[][]dp = DTW.compute(Arrays.copyOf(a,5),Arrays.copyOf(b,3));
//        double[][] dp = DTW.compute(a,b);
        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[4][2]);
    }
}