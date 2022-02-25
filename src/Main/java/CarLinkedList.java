public class CarLinkedList implements CarList {

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public void add(Car car, int index) {

    }

    @Override
    public Car get(int index) {
        return null;
    }

    @Override
    public void add(Car car) {
        if (size == 0) {
            first = new Node(null, car, null);
            last = first;
        } else {
            Node secondLast = last;
            Node nodeNew = new Node(secondLast, car, null);
            secondLast.next = nodeNew;
        }
        size++;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        return false;
    }

    @Override
    public int size() {
        return size();
    }

    @Override
    public void clear() {

    }

    private Node getNode(int index) {
        Node node = first;
        for (int i = 0; i < index; ++i) {
            node = node.next;
        }
        return node;
    }

    private static class Node {
        private Node previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
