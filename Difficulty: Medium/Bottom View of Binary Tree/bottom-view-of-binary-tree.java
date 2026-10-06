/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

import java.util.*;

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        TreeMap<Integer, Integer> bottomViewMap = new TreeMap<>();

        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> p = q.poll();
            Node node = p.getKey();
            int hd = p.getValue();

            bottomViewMap.put(hd, node.data);

            if (node.left != null)
                q.add(new Pair<>(node.left, hd - 1));
            if (node.right != null)
                q.add(new Pair<>(node.right, hd + 1));
        }

        for (Map.Entry<Integer, Integer> entry : bottomViewMap.entrySet())
            res.add(entry.getValue());

        return res;
    }

    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}