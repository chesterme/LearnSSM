package ch10.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "book")
public class Book {

    @Value("1")
    private Long id;
    @Value("数据库系统概念")
    private String bookName;
    @Value("Abraham Silberschata, Henry F.Korth, S.Sudarshan")
    private String author;
    @Value("机械工业出版社")
    private String publish;

    public Book(Long id, String bookName, String author, String publish) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.publish = publish;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String toString(){
        return "id: " + id + ", bookName: " + bookName + ", author: " + author + ", publish: " + publish;
    }
}
