/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

// class Solution {
//     public Node constructTree(int[] pre, int[] post) {
//         // code here
        
//     }
// }



class Solution {
    int preIndex = 0;
    HashMap<Integer,Integer> postMap;
    public Node constructTree(int[] pre, int[] post) {
        // code here
    postMap = new HashMap<>();
    for(int i = 0; i < post.length; i++) postMap.put(post[i], i);
    preIndex = 0;
    return constructFromPrePost(pre, post, 0,post.length-1);
    }
    
    Node constructFromPrePost(int[] pre, int[] post, int postStart, int postEnd) {
    if(postStart>postEnd) return null;
    Node root = new Node(pre[preIndex++]);
    if(postStart == postEnd ) return root;
    int i = postMap.get(pre[preIndex]);
 
    root.left = constructFromPrePost(pre, post, postStart, i);
    root.right = constructFromPrePost(pre, post, i + 1, postEnd-1);

    return root;
    }
}