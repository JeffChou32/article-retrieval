package articles;
public abstract class MyAbstractList<E> implements MyList<E> { 
    protected int size = 0;
    
    protected MyAbstractList() { }  //default constructor
    
    protected MyAbstractList(E[] objects) { //value constructor
        for (E element : objects) {
            add(element);
        }
    }
    
    @Override
    public void add(E e) {
        add(size, e);
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public int size() { return size; }
    
    @Override
    public boolean remove(E e) {
        int index = indexOf(e);
        if (index > 0) {
            remove(index);
            return true;
        }
        else
            return false;
    }
}