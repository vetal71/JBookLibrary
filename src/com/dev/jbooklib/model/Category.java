package com.dev.jbooklib.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Category {

    private final IntegerProperty categoryId;
    private final StringProperty categoryName;
    private final IntegerProperty parentId;

    /**
     * конструктор по умолчанию
      */
    public Category() {
        this(null, null, null);
    }

    /**
     * конструктор параметризованный
     * @param categoryId
     * @param categoryName
     * @param parentId
     */
    public Category(IntegerProperty categoryId, StringProperty categoryName, IntegerProperty parentId) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.parentId = parentId;
    }

    public int getCategoryId() {
        return categoryId.get();
    }

    public IntegerProperty categoryIdProperty() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
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

    public int getParentId() {
        return parentId.get();
    }

    public IntegerProperty parentIdProperty() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId.set(parentId);
    }
}
