package com.dev.jbooklib.service;

import com.dev.jbooklib.model.CategoryModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.dev.jbooklib.util.MyUtils.showError;

public class CategoryService {
    
    private Connection con;

    /**
     * конструктор с параметром
     * @param con - соединение с БД
     */
    public CategoryService(Connection con) {
        this.con = con;
    }

    /**
     * получить список категорий
     */
    public ObservableList<CategoryModel> getCategories() {
        ObservableList<CategoryModel> dataCategoryModel = FXCollections.observableArrayList();
        try {
            ResultSet rs = con.createStatement()
                    .executeQuery("SELECT id, categoryname, parent_id, (SELECT COUNT(*) from BOOKS b WHERE c.ID = b.CATEGORY_ID) as bookcount FROM Categories c");
            while (rs.next()) {
                CategoryModel cat = new CategoryModel();
                cat.setCategoryId(rs.getInt("id"));
                cat.setCategoryName(rs.getString("categoryname"));
                cat.setParentId(rs.getInt("parent_id"));
                cat.setBookCount(rs.getInt("bookcount"));
                dataCategoryModel.add(cat);
            }
        } catch (SQLException e) {
            showError("Ошибка получения списка категорий", e.getMessage());
        }
        return dataCategoryModel;
    }

    public CategoryModel getCategory(Integer id) {
        CategoryModel cat = new CategoryModel();
        try {
            ResultSet rs = con.createStatement()
                .executeQuery("SELECT id, categoryname, parent_id, (SELECT COUNT(*) from BOOKS b WHERE c.ID = b.CATEGORY_ID) as bookcount FROM Categories c WHERE c.id = " + id.toString());
            while (rs.next()) {
                cat.setCategoryId(rs.getInt("id"));
                cat.setCategoryName(rs.getString("categoryname"));
                cat.setParentId(rs.getInt("parent_id"));
                cat.setBookCount(rs.getInt("bookcount"));
            }
        } catch (SQLException e) {
            showError("Ошибка получения списка категорий", e.getMessage());
        }
        return cat;
    }

    public Boolean hasChild(CategoryModel cat) {
        Integer count = 0;
        try {
            ResultSet rs = con.createStatement()
                    .executeQuery("SELECT count(*) as cnt FROM CATEGORIES WHERE parent_id = " + cat.getCategoryId());
            while (rs.next()) {
                count = rs.getInt("cnt");
            }
        } catch (SQLException e) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, e);
        }
        return count != 0;
    }

}
