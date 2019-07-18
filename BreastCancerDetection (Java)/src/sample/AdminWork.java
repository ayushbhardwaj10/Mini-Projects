package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminWork {

    public void returnHome(MouseEvent event) throws Exception {
        ((Node) event.getSource()).getScene().getWindow().hide(); // to hide previous window

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Index.fxml"));
        Scene scene = new Scene(root, 1300, 680);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void insert(ActionEvent event) throws Exception{
        ((Node) event.getSource()).getScene().getWindow().hide(); // to hide previous window

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Admin_Insert.fxml"));
        Scene scene = new Scene(root, 1300, 680);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void delete(ActionEvent event) throws Exception{
        ((Node) event.getSource()).getScene().getWindow().hide(); // to hide previous window

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Admin_delete.fxml"));
        Scene scene = new Scene(root, 1300, 680);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void show(ActionEvent event) throws Exception{
        ((Node) event.getSource()).getScene().getWindow().hide(); // to hide previous window

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Admin_show.fxml"));
        Scene scene = new Scene(root, 1300, 680);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
