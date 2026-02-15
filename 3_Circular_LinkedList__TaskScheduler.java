class Task {
    int taskId;
    String name;
    Task next;

    Task(int id, String name) {
        this.taskId = id;
        this.name = name;
    }
}

class TaskScheduler {
    Task head = null;

    void addTask(int id, String name) {
        Task newNode = new Task(id, name);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Task temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }

    void display() {
        if (head == null) return;

        Task temp = head;
        do {
            System.out.println(temp.taskId + " " + temp.name);
            temp = temp.next;
        } while (temp != head);
    }
}
