class Item {
    int id;
    String name;
    int quantity;
    double price;
    Item next;

    Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

class Inventory {
    Item head;

    void addItem(int id, String name, int q, double p) {
        Item newNode = new Item(id, name, q, p);

        if (head == null) {
            head = newNode;
            return;
        }

        Item temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    void totalValue() {
        double sum = 0;
        Item temp = head;

        while (temp != null) {
            sum += temp.quantity * temp.price;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: " + sum);
    }
}
