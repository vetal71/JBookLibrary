package com.dev.jbooklib.model;

import javafx.beans.property.*;

public class CategoryModel {

    private final ObjectProperty<Integer> categoryId;
    private final StringProperty categoryName;
    private final ObjectProperty<Integer> parentId;
    private final ObjectProperty<Integer> bookCount;

    /**
     * конструктор по умолчанию
      */
    public CategoryModel() {
        this(null, null, null, null);
    }

    /**
     * конструктор параметризованный
     * @param bookCnt
     * @param name
     * @param parId
     */
    public CategoryModel(Integer id, String name, Integer parId, Integer bookCnt) {
        this.categoryId = new SimpleObjectProperty<Integer>(id);
        this.categoryName = new SimpleStringProperty(name);
        this.bookCount = new SimpleObjectProperty<Integer>(bookCnt);
        this.parentId = new SimpleObjectProperty<Integer>(parId);
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

    public String getCategoryName() {
        return categoryName.get();
    }

    public StringProperty categoryNameProperty() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName.set(categoryName);
    }

    public Integer getParentId() {
        return parentId.get();
    }

    public ObjectProperty<Integer> parentIdProperty() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId.set(parentId);
    }

    public Integer getBookCount() {
        return bookCount.get();
    }

    public ObjectProperty<Integer> bookCountProperty() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount.set(bookCount);
    }
}
