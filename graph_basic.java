import java.util.List;

public class graph_basic {

    // adjacent table
    // graph[x] stores all the neighbor nodes of x
    List<Integer>[] graph;

    // adjacent matrix
    // matrix[x][y] stores if x has a link to y
    boolean[][] matrix;

    // for weighed graph
    List<int[]>[] weighted_graph;
    int[][] weighted_matrix;


}
