import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StructureSimilarity {
    // constructing the context graph
    public static final int INF = Integer.MAX_VALUE;
    //
    public Integer[][][] structSimi;
    public Integer[][] hopCountResult;
    // array degrees maintains the degrees of each node
    public int[] degrees;
    // diam estimates the diameter of the graph
    public int diam=0;
    // n estimates the number of nodes
    public int n;

    public StructureSimilarity(Integer[][] graph){
        // Initialization
        this.n = graph[0].length;
        this.hopCountResult = Floyd.hopCount(graph);
        this.degrees = new int[n];
        for (int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if(hopCountResult[i][j]==1)
                    degrees[i]+=1;
                // Considering that multiple connected component may exist
                if(hopCountResult[i][j]!=INF)
                    diam = Math.max(diam,hopCountResult[i][j]);
            }
        this.structSimi = new Integer[diam+1][n][n];
    }

    public void computeLayerK(int k){
        if(k<0||k>diam)
            return;
        if(k==0){
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    structSimi[0][i][j] = DTW.compute(getHopRingK(i,0),getHopRingK(j,0));
        }else{
            for (int i=0;i<n;i++)
                for(int j=0;j<n;j++){
                    if(structSimi[k-1][i][j]==null)
                        continue;
                    Integer temp = DTW.compute(getHopRingK(i,k),getHopRingK(j,k));
                    if(temp==null)
                        structSimi[k][i][j] = null;
                    else
                        structSimi[k][i][j] = structSimi[k-1][i][j]+ temp;
                }
        }
    }

    public Integer[] getHopRingK(int node, int k){
        // return the ordered degree array s(R_k(node))
        if(node<0||node>n-1||k<0||k>diam)
            return new Integer[0];
        List<Integer> result = new ArrayList<Integer>();
        for (int j=0;j<n;j++)
            if(hopCountResult[node][j]==k)
                result.add(degrees[j]);
        Integer[] res = new Integer[result.size()];
        for(int i=0;i<result.size();i++)
            res[i] = result.get(i);
        Arrays.sort(res);
        return res;
    }


}
