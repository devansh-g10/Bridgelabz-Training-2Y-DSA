class Process {
    int pid;
    int burst;
    Process next;

    Process(int pid, int burst) {
        this.pid = pid;
        this.burst = burst;
    }
}

class RoundRobin {
    Process head = null;

    void addProcess(int pid, int burst) {
        Process newNode = new Process(pid, burst);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Process temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }
}
