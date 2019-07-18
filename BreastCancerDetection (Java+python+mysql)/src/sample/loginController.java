package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    public LoginModel loginModel = new LoginModel();

    @FXML
    private Label isconnected;
    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField txtPassword;


    public void Login(ActionEvent event) throws IOException {

        try {
            if(loginModel.isLogin(txtUserName.getText(),txtPassword.getText()))
            {   ((Node)event.getSource()).getScene().getWindow().hide(); // to hide previous window

                Stage primaryStage = new Stage();
                Parent root =  FXMLLoader.load(getClass().getResource("Mail.fxml"));
                Scene scene = new Scene(root,1300,670);
                //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            else isconnected.setText("User/Password Incorrect..!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(loginModel.isDbConnected()){
            isconnected.setText("Connected");
        }
        else isconnected.setText("Connection Failed..!!");
    }
}

