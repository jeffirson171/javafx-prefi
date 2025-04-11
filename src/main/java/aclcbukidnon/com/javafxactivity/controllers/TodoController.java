package aclcbukidnon.com.javafxactivity.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TodoController {

    @FXML
    private ListView<String> todoList;

    private final ObservableList<String> todos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        todos.add("Remove Me");
        todoList.setItems(todos);
        todoList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    protected void onCreateClick() {
        var dialog = new TextInputDialog("");
        dialog.setTitle("Create New Todo");
        dialog.setHeaderText("Enter a new todo item:");

        var result = dialog.showAndWait();
        result.ifPresent(text -> {
            if (!text.trim().isEmpty()) {
                todos.add(text);
            }
        });
    }

    @FXML
    protected void onDeleteClick() {
        int selectedIndex = todoList.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            var confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("Delete Confirmation");
            confirm.setHeaderText("Are you sure you want to delete this todo?");
            confirm.setContentText("This action cannot be undone.");

            var result = confirm.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                todos.remove(selectedIndex);
            }
        } else {
            showAlert("No Selection", "Please select a todo item to delete.");
        }
    }

    @FXML
    protected void onListEdit() {
        String selectedItem = todoList.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            var dialog = new TextInputDialog(selectedItem);
            dialog.setTitle("Edit Todo");
            dialog.setHeaderText("Modify your todo item:");

            var result = dialog.showAndWait();
            result.ifPresent(newText -> {
                if (!newText.trim().isEmpty()) {
                    int selectedIndex = todoList.getSelectionModel().getSelectedIndex();
                    todos.set(selectedIndex, newText);
                }
            });
        } else {
            showAlert("No Selection", "Please select a todo item to edit.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
