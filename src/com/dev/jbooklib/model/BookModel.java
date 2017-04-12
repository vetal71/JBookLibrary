package com.dev.jbooklib.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BookModel {

    private final ObjectProperty<Integer> bookId;
    private final StringProperty bookName;
    private final StringProperty bookLink;
    private final ObjectProperty<Integer> categoryId;

    /**
     * конструктор по умолчанию
     */
    public BookModel() {
        this(null, null, null, null);
    }

    /**
     * конструктор параметризованный
     * @param link
     * @param name
     * @param catId
     */
    public BookModel(Integer id, String name, String link, Integer catId) {
        this.bookId = new SimpleObjectProperty<Integer>(id);
        this.bookName = new SimpleStringProperty(name);
        this.bookLink = new SimpleStringProperty(link);
        this.categoryId = new SimpleObjectProperty<Integer>(catId);
    }

    public Integer getBookId() {
        return bookId.get();
    }

    public ObjectProperty<Integer> bookIdProperty() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId.set(bookId);
    }

    public String getBookName() {
        return bookName.get();
    }

    public StringProperty bookNameProperty() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName.set(bookName);
    }

    public String getBookLink() {
        return bookLink.get();
    }

    public StringProperty bookLinkProperty() {
        return bookLink;
    }

    public void setBookLink(String bookLink) {
        this.bookLink.set(bookLink);
    }

    public Integer getCategoryId() {
        return categoryId.get();
    }

    public ObjectProperty<Integer> categoryIdProperty() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId.set(categoryId);
    }
}
