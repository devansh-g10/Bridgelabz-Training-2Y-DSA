import java.util.*;

class Node {
    String name;
    List<Node> children;

    Node(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
}

public class FileSystemTree {

    // 🔹 Preorder: Root → Children
    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.name + " ");
        for (Node child : root.children) {
            preorder(child);
        }
    }

    // 🔹 Inorder (for N-ary tree: first child → root → rest children)
    public static void inorder(Node root) {
        if (root == null) return;

        if (root.children.size() > 0) {
            inorder(root.children.get(0));
        }

        System.out.print(root.name + " ");

        for (int i = 1; i < root.children.size(); i++) {
            inorder(root.children.get(i));
        }
    }

    // 🔹 Postorder: Children → Root
    public static void postorder(Node root) {
        if (root == null) return;

        for (Node child : root.children) {
            postorder(child);
        }

        System.out.print(root.name + " ");
    }

    public static void main(String[] args) {

        // 🌳 Build Tree
        Node root = new Node("root");
        Node home = new Node("home");
        Node var = new Node("var");
        Node user = new Node("user");
        Node docs = new Node("docs");
        Node log = new Node("log");
        Node config = new Node("config");

        root.children.add(home);
        root.children.add(var);

        home.children.add(user);
        home.children.add(docs);

        var.children.add(log);

        user.children.add(config);

        // 🔹 d) Traversals
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
    }
}