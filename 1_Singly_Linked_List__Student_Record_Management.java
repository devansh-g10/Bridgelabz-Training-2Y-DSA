class Student {
    int rollNo;
    String name;
    int age;
    String grade;
    Student next;

    Student(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentManagement {
    Student head;

    void addAtEnd(int rollNo, String name, int age, String grade) {
        Student newNode = new Student(rollNo, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        Student temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    void deleteByRoll(int rollNo) {
        if (head == null) return;

        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    void display() {
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.rollNo + " " + temp.name + " " + temp.grade);
            temp = temp.next;
        }
    }
}
