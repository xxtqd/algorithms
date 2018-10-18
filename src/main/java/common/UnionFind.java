package common;

/**
 * Created by xu_xt on 7/4/18.
 */
public class UnionFind {
    private int[] root;
    UnionFind(int n) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }

    public void union(int x, int y) {
        int rootA = find(x);
        int rootB = find(y);
        if (rootA != rootB) {
            root[rootA] = rootB;
        }
    }

    public int find(int x) {
        while (x != root[x]) {
            root[x] = root[root[x]];
            x = root[x];
        }
        return x;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
 }
