

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
import java.util.*;

class Solution {
    public ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++)
            {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.data);

                if (currentNode.left != null)
                {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null)
                {
                    queue.add(currentNode.right);
                }
            }

            if (!leftToRight)
            {
                Collections.reverse(currentLevel);
            }

            for (int val : currentLevel)
            {
                result.add(val);
            }

            leftToRight = !leftToRight;
        }

        return result;
    }
}