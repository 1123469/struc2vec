import java.util.Arrays;

public class Floyd {
    public static final int INF = Integer.MAX_VALUE;
    public static Integer[][] hopCount(Integer[][] adj){
        // self implementation of hop-count demo based on Floyd algorithm
        int len = adj.length;
        Integer[][] result = Arrays.copyOf(adj,len);
        for(int k=0;k<len;k++)
            for(int i=0;i<len;i++)
                for (int j=0;j<len;j++)
                    result[i][j] = (result[i][k]==INF||result[k][j]==INF)?result[i][j]:Math.min(result[i][j],result[i][k]+result[k][j]);
        return result;
    }

    public static  void main(String[]args){
        // test on floyd
        Integer[][] mat = {
                {0,1,INF,INF,INF},
                {1,0,1,INF,INF},
                {INF,1,0,1,INF},
                {INF,INF,1,0,1},
                {INF,INF,INF,1,0},
        };

        System.out.println(Arrays.deepToString(hopCount(mat)));
    }
}
