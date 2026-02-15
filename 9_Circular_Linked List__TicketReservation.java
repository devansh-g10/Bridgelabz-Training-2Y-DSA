class Ticket {
    int id;
    String customer;
    Ticket next;

    Ticket(int id, String customer) {
        this.id = id;
        this.customer = customer;
    }
}

class TicketSystem {
    Ticket head = null;

    void bookTicket(int id, String name) {
        Ticket newNode = new Ticket(id, name);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Ticket temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }
}
