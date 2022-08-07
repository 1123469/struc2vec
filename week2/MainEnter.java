import java.util.Arrays;

public class MainEnter {
    // Test Structure similarity
    // By computing the structure similarity of Barbell graph b(2,1)
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args){
        Integer[][] graph = {
                {0,1,INF,INF,INF},
                {1,0,1,INF,INF},
                {INF,1,0,1,INF},
                {INF,INF,1,0,1},
                {INF,INF,INF,1,0},
        };
        StructureSimilarity strSimi = new StructureSimilarity(graph);
        for(int i=0;i<=strSimi.diam;i++)
            strSimi.computeLayerK(i);
        System.out.println(Arrays.deepToString(strSimi.hopCountResult));
        System.out.println(Arrays.deepToString(strSimi.structSimi));
//        System.out.println(Arrays.deepToString(strSimi.hopCountResult));
//        System.out.println(Arrays.deepToString(strSimi.getHopRingK(0,1)));
    }
}
