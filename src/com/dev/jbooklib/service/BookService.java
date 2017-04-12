package com.dev.jbooklib.service;

import com.dev.jbooklib.database.DBConnection;
import com.dev.jbooklib.model.BookModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.dev.jbooklib.util.MyUtils.showError;

public class BookService {

    private Connection con;

    /**
     * конструктор с параметром
     * @param con - соединение с БД
     */
    public BookService(Connection con) {
        this.con = con;
    }

    /**
     * получить список категорий
     */
    public ObservableList<BookModel> getBooks(Integer id) {

        ObservableList<BookModel> dataBookModel = FXCollections.observableArrayList();
        try {
            String sqlText = "SELECT ID, BOOKNAME, BOOKLINK, CATEGORY_ID from BOOKS";
            if (id != 0) {
                sqlText = sqlText + " where category_id = ?";
            }
            PreparedStatement stmt = con.prepareStatement(sqlText);
            if (id != 0) {
                stmt.setInt(1, id);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BookModel book = new BookModel();
                book.setBookId(rs.getInt("id"));
                book.setBookName(rs.getString("bookname"));
                book.setBookLink(rs.getString("booklink"));
                book.setCategoryId(rs.getInt("category_id"));
                dataBookModel.add(book);
            }
        } catch (SQLException e) {
            showError("Ошибка получения списка книг", e.getMessage());
        }
        return dataBookModel;
    }

    public BookModel getCategory(Integer id) {
        BookModel book = new BookModel();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT ID, BOOKNAME, BOOKLINK, CATEGORY_ID from BOOKS where ID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                book.setBookId(rs.getInt("id"));
                book.setBookName(rs.getString("bookname"));
                book.setBookLink(rs.getString("booklink"));
                book.setCategoryId(rs.getInt("category_id"));
            }
        } catch (SQLException e) {
            showError(String.format("Ошибка получения книги по идентификатору (%d)", id), e.getMessage());
        }
        return book;
    }

    public static Integer getBookCount() {
        Connection con = DBConnection.getConnection();
        Integer result = 0;
        try {
            String sqlText = "select count(*) from books";
            PreparedStatement stmt = con.prepareStatement(sqlText);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            showError("Ошибка получения общего количества книг", e.getMessage());
        }
        return result;
    }

}
