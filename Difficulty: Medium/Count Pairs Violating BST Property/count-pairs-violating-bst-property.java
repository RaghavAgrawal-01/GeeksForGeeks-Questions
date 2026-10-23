/* BST Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int pairsViolatingBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return mergeSort(list, 0, list.size() - 1);
    }

    private void inorder(Node root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    private int mergeSort(ArrayList<Integer> list, int left, int right) {
        int count = 0;
        if(left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSort(list, left, mid);
            count += mergeSort(list, mid + 1, right);
            count += merge(list, left, mid, right);
        }
        return count;
    }

    private int merge(ArrayList<Integer> list, int left, int mid, int right) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = left;
        int j = mid + 1;
        int count = 0;

        while(i <= mid && j <= right) {
            if(list.get(i) <= list.get(j)) {
                temp.add(list.get(i));
                i++;
            } else {
                temp.add(list.get(j));
                count += (mid - i + 1);
                j++;
            }
        }

        while(i <= mid) {
            temp.add(list.get(i));
            i++;
        }

        while(j <= right) {
            temp.add(list.get(j));
            j++;
        }

        for(int k = left; k <= right; k++) {
            list.set(k, temp.get(k - left));
        }

        return count;
    }
}