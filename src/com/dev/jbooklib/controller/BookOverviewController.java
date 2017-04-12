package com.dev.jbooklib.controller;

import com.dev.jbooklib.MainApp;
import com.dev.jbooklib.database.DBConnection;
import com.dev.jbooklib.model.BookModel;
import com.dev.jbooklib.model.CategoryModel;
import com.dev.jbooklib.service.BookService;
import com.dev.jbooklib.service.CategoryService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BookOverviewController implements Initializable {

    private MainApp mainApp;
    private ObservableList<CategoryModel> dataCategoryModel;
    private ObservableList<BookModel> dataBookModel;
    private TreeTableView.TreeTableViewSelectionModel<CategoryModel> selCat;
    private BookService bs;
    private CategoryService cs;

    @FXML
    private TreeTableView<CategoryModel> tvCategory;
    @FXML
    private TreeTableColumn<CategoryModel, Integer> colId;
    @FXML
    private TreeTableColumn<CategoryModel, String> colName;
    @FXML
    private TreeTableColumn<CategoryModel, Integer> colCount;
    @FXML
    private TreeTableColumn<CategoryModel, Integer> colPrnt;

    @FXML
    private TableView<BookModel> tbvBook;
    @FXML
    private TableColumn<BookModel, Integer> colBookId;
    @FXML
    private TableColumn<BookModel, String> colBookName;
    @FXML
    private TableColumn<BookModel, String> colBookLink;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // создаем сервисы
        Connection con = DBConnection.getConnection();
        bs = new BookService(con);
        cs = new CategoryService(con);

        // отобразим дерево категорий
        showCategoryTree();
        // отобразим таблицу книг
        showBook();
    }

    private void showCategoryTree() {
        colId.setCellValueFactory(
                new TreeItemPropertyValueFactory<CategoryModel, Integer>("categoryId")
        );
        colName.setCellValueFactory(
                new TreeItemPropertyValueFactory<CategoryModel, String>("categoryName")
        );
        colCount.setCellValueFactory(
                new TreeItemPropertyValueFactory<CategoryModel, Integer>("bookCount")
        );
        colPrnt.setCellValueFactory(
                new TreeItemPropertyValueFactory<CategoryModel, Integer>("parentId")
        );

        dataCategoryModel = cs.getCategories();

        List<CategoryModel> categories = new ArrayList<CategoryModel>(); //list for roots
        List<CategoryModel> roots = new ArrayList<CategoryModel>();      //list for goods themselves
        for (CategoryModel cat : dataCategoryModel) {
            if (cs.hasChild(cat)) {
                roots.add(cat);
            } else {
                categories.add(cat);
            }
        }
        TreeItem<CategoryModel> rootItem = new TreeItem<CategoryModel>(cs.getCategory(1)); //the main root
        for (CategoryModel root : roots) {
            Integer categoryId = root.getCategoryId();
            if (categoryId == 1) {
                continue;
            }
            TreeItem<CategoryModel> rootTreeItem = new TreeItem<CategoryModel>(root);
            for (CategoryModel cat : categories) {//looking for goods for each folder
                if (cat.getParentId() == categoryId) {
                    TreeItem<CategoryModel> goodTreeItem = new TreeItem<CategoryModel>(cat);
                    rootTreeItem.getChildren().add(goodTreeItem);
                }
            }
            rootTreeItem.setExpanded(true);
            rootItem.getChildren().add(rootTreeItem);//adding every folder to the main root
        }
        rootItem.setExpanded(true);
        tvCategory.setRoot(rootItem);

        tvCategory.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                updateBookView();
            }
        });

    }

    private void showBook() {
        colBookId.setCellValueFactory(
                new PropertyValueFactory<BookModel, Integer>("bookId")
        );
        colBookName.setCellValueFactory(
                new PropertyValueFactory<BookModel, String>("bookName")
        );
        colBookLink.setCellValueFactory(
                new PropertyValueFactory<BookModel, String>("bookLink")
        );

        updateBookView();
    }

    private void updateBookView() {
        selCat = tvCategory.getSelectionModel();
        Integer selCatId = 0;
        TreeItem<CategoryModel> selItem = selCat.getSelectedItem();
        if (selItem != null) {
            CategoryModel cat = selItem.getValue();
            if (cat != null) {
                selCatId = cat.getCategoryId();
            }
        }
        dataBookModel = bs.getBooks(selCatId);
        tbvBook.setItems(dataBookModel);
    }

}
