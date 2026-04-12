import java.util.*;

class ExpressionTree {

    static class Node {
        String val;
        Node left, right;

        Node(String val) {
            this.val = val;
        }
    }

    // 🔹 Preorder
    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // 🔹 Inorder (with parentheses)
    public static void inorder(Node root) {
        if (root == null) return;

        if (root.left != null) System.out.print("(");

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);

        if (root.right != null) System.out.print(")");
    }

    // 🔹 Postorder
    public static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // 🔹 Evaluate Postfix
    public static int evaluatePostfix(String[] postfix) {
        Stack<Integer> stack = new Stack<>();

        for (String token : postfix) {
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

        // 🌳 Build Tree for (3+5)*(8-2)
        Node root = new Node("*");
        root.left = new Node("+");
        root.right = new Node("-");
        root.left.left = new Node("3");
        root.left.right = new Node("5");
        root.right.left = new Node("8");
        root.right.right = new Node("2");

        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();

        // Evaluate
        String[] postfix = {"3","5","+","8","2","-","*"};
        System.out.println("Evaluation: " + evaluatePostfix(postfix));
    }
}