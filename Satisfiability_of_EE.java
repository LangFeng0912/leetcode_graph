//将 equations 中的算式根据 == 和 != 分成两部分，
// 先处理 == 算式，使得他们通过相等关系各自勾结成门派（连通分量）；
// 然后处理 != 算式，检查不等关系是否破坏了相等关系的连通性。

public class Satisfiability_of_EE {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        // 先让相等的字母形成连通分量
        for (String eq : equations) {
            char p = eq.charAt(0);
            char q = eq.charAt(3);
            if (eq.charAt(1) == '=') {
                uf.union(p - 'a', q - 'a');
            }
        }
        // 检查不等关系是否打破相等关系的连通性
        for (String eq : equations) {
            char p = eq.charAt(0);
            char q = eq.charAt(3);
            if (eq.charAt(1) == '!') {
                if (uf.connected(p - 'a', q - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}


