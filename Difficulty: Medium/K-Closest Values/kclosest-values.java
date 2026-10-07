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

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        // Create an array list to store the inorder traversal of the tree
        ArrayList<Integer> in = new ArrayList<>();
        inorder(root, in); // Pass in the list to the inorder function
        
        ArrayList<Integer> res = new ArrayList<>();
        int n = in.size();
        
        // Find the index of the element closest to the target
        int idx = getElementClosestToTarget(in, target);
        
        // Two-pointer approach
        int l = idx, h = idx + 1;
        while (k > 0) {
            // Take from lower side
            if (l >= 0 && (h == n || Math.abs(in.get(l) - target) <= Math.abs(in.get(h) - target))) {
                res.add(in.get(l)); // Fix typo "geat" to "get"
                l--;
            } else {
                res.add(in.get(h));
                h++;
            }
            k--;
        }
        return res;
    }

    // Helper function for inorder traversal
    void inorder(Node root, ArrayList<Integer> in) {
        if (root == null) return;
        
        inorder(root.left, in); // Traverse left subtree
        in.add(root.data);       // Add node value to inorder list
        inorder(root.right, in); // Traverse right subtree
    }

    // Binary search to get the element closest to target
    int getElementClosestToTarget(ArrayList<Integer> arr, int target) {
        int l = 0, h = arr.size() - 1, idx = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            
            if (arr.get(mid) <= target) {
                idx = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return idx;
    }
}
