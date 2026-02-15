class User {
    int id;
    String name;
    User next;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class SocialMedia {
    User head;

    void addUser(int id, String name) {
        User newNode = new User(id, name);
        newNode.next = head;
        head = newNode;
    }

    void display() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.id + " " + temp.name);
            temp = temp.next;
        }
    }
}
