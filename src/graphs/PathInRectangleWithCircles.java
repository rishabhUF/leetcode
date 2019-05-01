package graphs;

public class PathInRectangleWithCircles {

    static  boolean ifPathExists(int n, int m, int k, int[] X, int[] Y) {
        if(n == 0 && m == 0) {
            return false;
        }

        int[][] graph = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {

                if((i-X[0])*(i-X[0]) + (j-Y[0])*(j-Y[0]) < k * k) {
                    graph[i][j] = 1;
                }
                if((i-X[1])*(i-X[1]) + (j-Y[1])*(j-Y[1]) < k * k) {
                    graph[i][j] = 1;
                }
            }
        }
        boolean[] result = new boolean[1];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(graph[i][j] != 1){
                    DFSUtil(graph, i, j, result);
                }
            }
        }
        return result[0];
    }

    private static void DFSUtil(int[][] graph, int i, int j, boolean[] res) {

        if(i == graph.length && j == graph[0].length) {
            res[0] = true;
            return;
        }

        if(i > graph.length && i < graph[0].length && j > graph.length && j < graph[0].length && graph[i][j] != 1) {
            DFSUtil(graph, i-1,j-1, res);
            DFSUtil(graph, i-1,j+1, res);
            DFSUtil(graph, i,j-1, res);
            DFSUtil(graph, i,j+1, res);
            DFSUtil(graph, i+1,j-1, res);
            DFSUtil(graph, i+1,j+1, res);
            DFSUtil(graph, i-1,j, res);
            DFSUtil(graph, i+1,j, res);
        }
    }

    public static void main(String[] args) {
        System.out.println(PathInRectangleWithCircles.ifPathExists(5,5,2, new int[]{1,3}, new int[]{3,3}));
    }
}
