public class LinkedList {
    private Node head;
    private int size;

    private class Node {
        String value;
        Node link;

        Node(String value) {
            this.value = value;
            size++;
        }
    }

    public LinkedList() {
        head = null;
        size = 0;
    }
    public void add(String s) {
        Node node = new Node(s);
        node.link = head;
        head = node;
    }
    public int getSize() {
        return size;
    }
    public String[] toArray() {
        String[] array = new String[size];
        int i = 0;
        Node node = head;
        while (node != null) {
            array[i++] = node.value;
            node = node.link;
        }
        return array;
    }
}
