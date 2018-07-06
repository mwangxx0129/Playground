public class UnionFind {
    private int[] father;
    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; ++ i) {
            father[i] = i;
        }
    }

    public int find(int a) {
        int fa = father[a];
        if (fa == a)
            return fa;
        return father[a] = find(fa);
    }

    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            father[fa] = fb;
        }
    }
    // 1 2
    // 3 4
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        uf.union(1,2);
        uf.union(2,3);
        uf.union(3,4);
        uf.union(4,5);
        uf.union(1,4);

        uf.union(6,7);
        uf.union(7,8);
        uf.union(8,9);

    }
}
