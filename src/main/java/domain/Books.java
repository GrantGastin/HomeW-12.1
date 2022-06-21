package domain;

public class Books extends Product {
    private String author;

    public Books(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }
}