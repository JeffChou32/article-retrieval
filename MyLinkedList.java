package articles;
public class MyLinkedList <E> extends MyAbstractList <E> { 
    private Node <E> head, tail;

    public MyLinkedList () { }

    /** Create a list from an array of objects */ 
    public MyLinkedList (E[]objects) {
        super (objects);
    }
    
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size

        if (tail == null) // The new node is the only node in list
            tail = head;
    }

    public E remove(int index) { return null;}
    public int lastIndexOf(E e) { return 0;}
    public int indexOf(E e) { return 0;}
    public E get(int index) { return null;}
    public boolean contains(E e) { return false;}
    public void clear() { } // will clear the list 
    public void add(int index, E e) { }
    
    @Override
    public String toString() {
        Node<E> current = head;
        StringBuilder result = new StringBuilder("");
        if (current != null)
            result.append("\t→");
        while (current != null) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append("\n\t→");
            }
        }
        return result.toString();
    }
}

 