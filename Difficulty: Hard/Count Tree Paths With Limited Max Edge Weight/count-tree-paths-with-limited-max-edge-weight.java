class Solution {
    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int i) {
            if(parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        long union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if(rootI != rootJ) {
                long paths = (long) size[rootI] * size[rootJ];
                if(size[rootI] < size[rootJ]) {
                    parent[rootI] = rootJ;
                    size[rootJ] += size[rootI];
                } else {
                    parent[rootJ] = rootI;
                    size[rootI] += size[rootJ];
                }
                return paths;
            }
            return 0;
        }
    }

    class Query implements Comparable<Query> {
        int weight;
        int index;

        Query(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }

        public int compareTo(Query other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int qLen = queries.length;
        Query[] qArr = new Query[qLen];
        for(int i = 0; i < qLen; i++) {
            qArr[i] = new Query(queries[i], i);
        }
        Arrays.sort(qArr);

        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(qLen, 0));
        DSU dsu = new DSU(n);

        int edgeIdx = 0;
        int eLen = edges.length;
        long totalPaths = 0;

        for(int i = 0; i < qLen; i++) {
            while(edgeIdx < eLen && edges[edgeIdx][2] <= qArr[i].weight) {
                totalPaths += dsu.union(edges[edgeIdx][0], edges[edgeIdx][1]);
                edgeIdx++;
            }
            ans.set(qArr[i].index, (int) totalPaths);
        }

        return ans;
    }
}