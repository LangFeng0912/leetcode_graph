package dfs_mid;

import java.util.*;

//   给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
//
//        岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
//
//        你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
//
//        返回必须翻转的 0 的最小数目。
public class ShortestB {

    List<int[]> island1 = new ArrayList<>();
    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int is1_r = 0, is1_c = 0;
        for(int i = 0 ;i<m; i++){
            for(int j = 0; j<n;j++){
                if(grid[i][j] == 1){
                    is1_r = i;
                    is1_c = j;
                    break;
                }
            }
        }
        boolean[][] visited = new boolean[m][n];
        BFS(grid,is1_r,is1_c,visited);
        int l = island1.size();
        // System.out.println(l);

        Queue<int[]> que = new LinkedList<>();
        for(int k = 0 ;k<l; k++){
            que.offer(island1.get(k));
            grid[island1.get(k)[0]][island1.get(k)[1]] = -1;
        }
        int step = 0;
        boolean[][] v1 = new boolean[m][n];
        while(!que.isEmpty()){
            int s = que.size();
            // System.out.println(que.size());
            while(s-- > 0){
                int[] cor = que.poll();
                int p = cor[0],q = cor[1];
                if(p<0 || p>=m || q<0 || q>= n){
                    continue;
                }
                if(v1[cor[0]][cor[1]]){
                    continue;
                }
                v1[cor[0]][cor[1]] = true;
                if(grid[cor[0]][cor[1]] == 1){
                    return step-1;
                }
                que.offer(new int[]{p-1, q});
                que.offer(new int[]{p+1, q});
                que.offer(new int[]{p, q-1});
                que.offer(new int[]{p, q+1});
            }
            step= step+1;
        }


        return 1;





    }

    public void BFS(int[][] grid, int i, int j, boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || i>=m || j<0 || j>= n){
            return;
        }
        if(visited[i][j]) return;
        visited[i][j] = true;
        if(grid[i][j] != 1){
            return;
        }
        int[] cor = new int[2];
        cor[0] = i; cor[1] = j;
        island1.add(cor);
        BFS(grid, i-1,j,visited);
        BFS(grid, i+1,j,visited);
        BFS(grid, i,j-1,visited);
        BFS(grid, i,j+1,visited);
    }
}
