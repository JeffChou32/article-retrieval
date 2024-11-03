package articles;
class Element<E> {
    protected E keyword;
    protected MyLinkedList<Article> list;
    
    public Element(E e) {
        keyword = e;
        list = new MyLinkedList<>();
    }
}