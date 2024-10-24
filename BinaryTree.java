package Tree;
// Define the Node class representing each node in the binary tree
class Node {
    int data;
    Node left, right;

    // Constructor to initialize a node
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

// Define the BinaryTree class
class BinaryTree {
    // Root of the binary tree
    Node root;

    // Constructor to initialize an empty tree
    public BinaryTree() {
        root = null;
    }

    // Insert a new node into the binary tree
    public Node insert(Node root, int data) {
        // If the tree is empty, create a new root node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recur down the tree to insert in left or right subtree
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            // If the data is a duplicate, we print a message and don't insert it
            System.out.println("Duplicate element not allowed: " + data);
        }
        return root;
    }

    // Display the binary tree using in-order traversal (Left, Root, Right)
    public void inorder(Node root) {
        if (root == null) {
            return;
        }

        // Recur on the left child
        inorder(root.left);

        // Print the root node's data
        System.out.print(root.data + " ");

        // Recur on the right child
        inorder(root.right);
    }

    // Wrapper for insert method
    public void insert(int data) {
        root = insert(root, data);
    }

    // Wrapper for inorder method
    public void inorder() {
        inorder(root);
    }

    // Main method to test the BinaryTree class
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes into the binary tree
        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.insert(6);
        tree.insert(14);
        tree.insert(4);
        tree.insert(7);
        tree.insert(13);

        // Display the binary tree in sorted order (in-order traversal)
        System.out.println("In-order traversal of the binary tree:");
        tree.inorder();
    }
}
