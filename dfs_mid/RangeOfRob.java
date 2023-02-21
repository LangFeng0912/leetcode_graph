package dfs_mid;

public class RangeOfRob {
    int count = 0;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        dfs(0,0,m,n,k);
        return count;

    }

    public void dfs(int i, int j,int m, int n, int k){
        if(i<0 || i>=m || j<0 || j>=n){
            return;
        }
        if(visited[i][j]){
            // System.out.println("P!");
            return;
        }
        if(k<cal(i,j)){
            return;
        }
        visited[i][j] = true;
        count ++;

        dfs(i-1,j,m,n,k);
        dfs(i+1,j,m,n,k);
        dfs(i,j-1,m,n,k);
        dfs(i,j+1,m,n,k);
    }

    public int cal(int i, int j){
        int h_i = i/100;
        int t_i = (i%100)/10;
        int i_0 = i-h_i*100-t_i*10;

        int h_j = j/100;
        int t_j = (j%100)/10;
        int j_0 = j-h_j*100-t_j*10;
        return h_i+t_i+i_0+h_j+t_j+j_0;
    }
}
