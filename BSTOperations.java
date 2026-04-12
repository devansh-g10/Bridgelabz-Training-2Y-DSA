class BSTOperations {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    // 🔹 Insert
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    // 🔹 Find minimum (inorder successor)
    public static Node findMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    // 🔹 Delete node
    public static Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {

            // Case 1: no child
            if (root.left == null && root.right == null)
                return null;

            // Case 2: one child
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            // Case 3: two children
            Node successor = findMin(root.right);
            root.val = successor.val;
            root.right = delete(root.right, successor.val);
        }

        return root;
    }

    // 🔹 Inorder (for sorted output)
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // 🔹 Range Query
    public static void printInRange(Node root, int low, int high) {
        if (root == null) return;

        if (root.val > low)
            printInRange(root.left, low, high);

        if (root.val >= low && root.val <= high)
            System.out.print(root.val + " ");

        if (root.val < high)
            printInRange(root.right, low, high);
    }

    public static void main(String[] args) {

        int[] arr = {15, 10, 20, 8, 12, 17, 25};

        Node root = null;

        // Build BST
        for (int val : arr) {
            root = insert(root, val);
        }

        // 🔹 Delete 10
        root = delete(root, 10);
        System.out.print("After deleting 10: ");
        inorder(root);
        System.out.println();

        // 🔹 Insert 14
        root = insert(root, 14);
        System.out.print("After inserting 14: ");
        inorder(root);
        System.out.println();

        // 🔹 Insert 9
        root = insert(root, 9);
        System.out.print("After inserting 9: ");
        inorder(root);
        System.out.println();

        // 🔹 Range query
        System.out.print("Range [10-20]: ");
        printInRange(root, 10, 20);
    }
}