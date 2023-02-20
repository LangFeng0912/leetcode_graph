public class Num_ofProvinces {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        UF uf = new UF(m);
        for(int i = 0; i<m;i++){
            for(int j = 0; j<m;j++){
                if(isConnected[i][j] == 1){
                    uf.union(i,j);
                }
            }
        }

        return uf.count();
    }
}
