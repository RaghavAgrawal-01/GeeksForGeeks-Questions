/* Structure of binary Tree Node
class Node {
  public:
    int data;
    Node *left;
    Node *right;
    Node(int val) {
        data = val;
        left = right = nullptr;
    }
};*/

class Solution {
private:
    void serialize(Node* root, string& s) {
        if (!root) {
            s += "#,";
            return;
        }
        s += "^" + to_string(root->data) + ",";
        serialize(root->left, s);
        serialize(root->right, s);
    }

public:
    bool isSubTree(Node* root1, Node* root2) {
        if (!root2) return true;
        if (!root1) return false;

        string s1 = "", s2 = "";
        serialize(root1, s1);
        serialize(root2, s2);

        // Check if serialized s2 exists within s1
        return s1.find(s2) != string::npos;
    }
};