import java.util.*;

class FileNode {
    String name;
    int size; // if file
    List<FileNode> children;

    FileNode(String name, int size) {
        this.name = name;
        this.size = size;
        this.children = new ArrayList<>();
    }

    boolean isFile() {
        return children.isEmpty();
    }

    void addChild(FileNode child) {
        children.add(child);
    }
}

class Directory_Size_Calculator {

    static int calculateSize(FileNode node) {
        // Base Case: If file, return size
        if (node.isFile()) {
            return node.size;
        }

        // Recursive Case: Sum sizes of children
        int total = 0;
        for (FileNode child : node.children) {
            total += calculateSize(child);
        }
        return total;
    }

    public static void main(String[] args) {

        FileNode project = new FileNode("project", 0);

        FileNode src = new FileNode("src", 0);
        src.addChild(new FileNode("main.java", 100));
        src.addChild(new FileNode("utils.java", 50));

        FileNode docs = new FileNode("docs", 0);
        docs.addChild(new FileNode("readme.txt", 10));

        FileNode guides = new FileNode("guides", 0);
        guides.addChild(new FileNode("setup.pdf", 200));
        docs.addChild(guides);

        project.addChild(src);
        project.addChild(docs);
        project.addChild(new FileNode("config.xml", 20));

        System.out.println("Total Size: " + calculateSize(project) + " KB");
    }
}
