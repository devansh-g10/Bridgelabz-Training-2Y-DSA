class BST {

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

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // 🔹 Inorder Traversal (Sorted)
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // 🔹 Search with comparison trace
    public static boolean search(Node root, int key) {
        if (root == null) return false;

        System.out.print(root.val + " -> ");

        if (root.val == key) return true;
        else if (key < root.val) return search(root.left, key);
        else return search(root.right, key);
    }

    // 🔹 Validate BST
    public static boolean isValidBST(Node root, long min, long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return isValidBST(root.left, min, root.val) &&
               isValidBST(root.right, root.val, max);
    }

    // 🔹 Height
    public static int height(Node root) {
        if (root == null) return -1;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {

        int[] arr = {50, 30, 70, 20, 40, 60, 80, 10, 25};

        Node root = null;

        // Build BST
        for (int val : arr) {
            root = insert(root, val);
        }

        // 🔹 c) Inorder Traversal
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        // 🔹 b) Search 25 (with comparisons)
        System.out.print("Search path for 25: ");
        boolean found = search(root, 25);
        System.out.println(found ? "FOUND" : "NOT FOUND");

        // 🔹 d) Validate given wrong tree
        Node wrong = new Node(50);
        wrong.left = new Node(30);
        wrong.right = new Node(70);
        wrong.left.left = new Node(20);
        wrong.left.right = new Node(65); // ❌ wrong
        wrong.right.left = new Node(60);
        wrong.right.right = new Node(80);

        System.out.println("Is valid BST? " +
                isValidBST(wrong, Long.MIN_VALUE, Long.MAX_VALUE));

        // 🔹 e) Heights
        System.out.println("Height of constructed BST: " + height(root));
        System.out.println("Height of skewed BST (9 nodes): " + (9 - 1));
    }
}