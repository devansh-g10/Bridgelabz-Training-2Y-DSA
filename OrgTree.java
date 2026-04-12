import java.util.*;

class TreeNode {
    String name;
    List<TreeNode> children;

    TreeNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
}

public class OrgTree {

    // 🔹 Find Leaf Nodes
    public static void findLeafNodes(TreeNode root) {
        if (root == null) return;

        if (root.children.size() == 0) {
            System.out.print(root.name + " ");
        }

        for (TreeNode child : root.children) {
            findLeafNodes(child);
        }
    }

    // 🔹 Height of Tree (in edges)
    public static int height(TreeNode root) {
        if (root == null) return -1;

        int maxHeight = -1;
        for (TreeNode child : root.children) {
            maxHeight = Math.max(maxHeight, height(child));
        }

        return maxHeight + 1;
    }

    // 🔹 Depth of a Node
    public static int findDepth(TreeNode root, String target, int depth) {
        if (root == null) return -1;

        if (root.name.equals(target)) return depth;

        for (TreeNode child : root.children) {
            int result = findDepth(child, target, depth + 1);
            if (result != -1) return result;
        }

        return -1;
    }

    // 🔹 Find Ancestors
    public static boolean findAncestors(TreeNode root, String target) {
        if (root == null) return false;

        if (root.name.equals(target)) return true;

        for (TreeNode child : root.children) {
            if (findAncestors(child, target)) {
                System.out.print(root.name + " ");
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // 🌳 Build Tree
        TreeNode CEO = new TreeNode("CEO");
        TreeNode CTO = new TreeNode("CTO");
        TreeNode CFO = new TreeNode("CFO");
        TreeNode DevLead = new TreeNode("DevLead");
        TreeNode HR = new TreeNode("HR");
        TreeNode Dev1 = new TreeNode("Dev1");
        TreeNode Dev2 = new TreeNode("Dev2");

        CEO.children.add(CTO);
        CEO.children.add(CFO);

        CTO.children.add(DevLead);
        CTO.children.add(HR);

        DevLead.children.add(Dev1);
        DevLead.children.add(Dev2);

        // 🔹 a) Leaf Nodes
        System.out.print("Leaf Nodes: ");
        findLeafNodes(CEO);
        System.out.println();

        // 🔹 b) Height
        System.out.println("Height of Tree: " + height(CEO));

        // 🔹 c) Depth of DevLead
        System.out.println("Depth of DevLead: " + findDepth(CEO, "DevLead", 0));

        // 🔹 d) Ancestors of Dev1
        System.out.print("Ancestors of Dev1: ");
        findAncestors(CEO, "Dev1");
        System.out.println();

        // 🔹 e) Degree of CTO
        System.out.println("Degree of CTO: " + CTO.children.size());
    }
}