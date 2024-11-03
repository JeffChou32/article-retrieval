package articles;
public class Node<E> {
    E element;
    Node<E> next;
    
    public Node(E e) {
        element = e;
        next = null; //not necessary - objects set to null by default
    }
    
    @Override
    public String toString() {
        return "" + element;
    }
}