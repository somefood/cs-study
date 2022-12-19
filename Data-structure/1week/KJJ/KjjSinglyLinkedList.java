public class KjjSinglyLinkedList implements SinglyLinkedList {

    public static final int MIN_VALUE = -2_000_000_000;
    public static final int MAX_VALUE = 2_000_000_000;
    public static final int MIN_INDEX = 0;

    private int size = 0;
    private Node head;

    public KjjSinglyLinkedList() {
    }

    public KjjSinglyLinkedList(Node head) {
        this.head = head;
    }

    @Override
    public boolean add(int data) {
        try {
            validateData(data);
            addToTail(data);
            size++;

            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    private void addToTail(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node tail = getNodeAt(this.size - 1);
        tail.next = newNode;
    }

    private Node getNodeAt(int index) {
        Node searchNode = head;

        while (index-- > MIN_INDEX) {
            searchNode = searchNode.next;
        }

        return searchNode;
    }

    private void validateData(int data) {
        if (MIN_VALUE > data || MAX_VALUE < data) {
            throw new IllegalArgumentException("[ERROR] int range 를 넘어서는 data 값 입니다.");
        }
    }

    @Override
    public int find(int index) {
        if (index >= size || index < MIN_INDEX) {
            throw new IllegalArgumentException("[ERROR] 배열의 크기를 넘어서는 index입니다.");
        }

        Node node = getNodeAt(index);

        return node.data;
    }

    @Override
    public int delete(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("[ERROR] 배열의 크기를 넘어서는 index입니다.");
        }

        int deletedData = deleteAt(index);
        size--;

        return deletedData;
    }

    private int deleteAt(int index) {
        if (index == 0) {
            return deleteFirstNode();
        } else if (index == size - 1) {
            return deleteLastNode();
        }
        return deleteNodeAt(index);
    }

    private int deleteNodeAt(int index) {
        Node exNode = getNodeAt(index - 1);
        Node deletedNode = getNodeAt(index);
        Node nextNode = getNodeAt(index + 1);

        exNode.next = nextNode;

        return deletedNode.data;
    }

    private int deleteLastNode() {
        Node deletedNode = getNodeAt(size - 2);
        deletedNode.next = null;

        return deletedNode.data;
    }

    private int deleteFirstNode() {
        Node deletedNode = head;
        head = head.next;

        return deletedNode.data;
    }

    @Override
    public void show() {
        if (size == 0) {
            System.out.println("empty list");
            return;
        }

        printAllNodes();
    }

    private void printAllNodes() {
        Node node = head;
        while (node != null) {
            System.out.print(node + " ");
            node = node.next;
        }
    }
}
