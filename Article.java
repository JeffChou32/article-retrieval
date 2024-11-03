package articles;
public class Article {
    int id;
    String title;
    String author;
    
    public Article(int id, String title, String a) {
        this.id = id;
        this.title = title;
        author = a;
    }
    
    @Override
    public String toString() {
        return String.format("|%d | %s | %s|", id, title, author);
    }
}