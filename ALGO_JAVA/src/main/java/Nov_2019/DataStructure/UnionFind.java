package Nov_2019.DataStructure;

public class UnionFind {
    int[] father;
    UnionFind(int n) {
        father = new int[n + 1];
        for (int i = 0 ; i < n + 1; ++ i) {
            father[i] = i;
        }
    }

    public int find(int x) {
        int fx = father[x];
        if (x == fx) return fx;
        else return father[x] = find(father[fx]);
    }

    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        father[fa] = fb;
    }
}
