package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.sql.* ;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class AdminLogin {

    //Go-back to Index page

    @FXML
    private Label status;

    @FXML
    private TextField user;

    @FXML
    private PasswordField password;

    public void returnHome(MouseEvent event) throws Exception {
        ((Node) event.getSource()).getScene().getWindow().hide(); // to hide previous window

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Index.fxml"));
        Scene scene = new Scene(root, 1300, 680);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void Login(ActionEvent event) throws Exception {
        {
            String UN = user.getText();
            String PWD = password.getText();

            String query = "select * from admin where username =? and password= ?;";

            Class.forName("org.sqlite.JDBC");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:sqlite:doctorsDB.sqlite");

            // Statement statement = conn.createStatement();

            PreparedStatement preparedStatement = null;
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, UN);
            preparedStatement.setString(2, PWD);
            ResultSet resultset = null;
            resultset = preparedStatement.executeQuery();

            // ResultSet resultset= statement.executeQuery(query);


                if (resultset.next()) {
                    status.setText("Succesfull");
                    // System.out.println(resultset.getString("username")+" " + resultset.getString("password"));
                    ((Node)event.getSource()).getScene().getWindow().hide(); // to hide previous window

                    Stage primaryStage = new Stage();
                    Parent root =  FXMLLoader.load(getClass().getResource("AdminWork.fxml"));
                    Scene scene = new Scene(root,1300,670);
                    //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                    primaryStage.setScene(scene);
                    primaryStage.show();

                } else {
                    status.setText("Login Failed");
                }

        }

    }
}


