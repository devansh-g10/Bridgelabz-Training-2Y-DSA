class TextState {
    String content;
    TextState next, prev;

    TextState(String content) {
        this.content = content;
    }
}

class TextEditor {
    TextState head, current;

    void addState(String text) {
        TextState newNode = new TextState(text);

        if (head == null) {
            head = current = newNode;
            return;
        }

        current.next = newNode;
        newNode.prev = current;
        current = newNode;
    }

    void undo() {
        if (current.prev != null)
            current = current.prev;
    }

    void redo() {
        if (current.next != null)
            current = current.next;
    }

    void display() {
        System.out.println("Current Text: " + current.content);
    }
}
