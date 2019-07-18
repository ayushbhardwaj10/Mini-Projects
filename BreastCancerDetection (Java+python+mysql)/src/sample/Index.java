package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Index implements Initializable
{
    @FXML
    private MediaView mediaView;


 public void AdminLoginPress(MouseEvent event) throws Exception
 {

     ((Node)event.getSource()).getScene().getWindow().hide(); // to hide previous window

     Stage primaryStage = new Stage();

     Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));

     Scene scene = new Scene(root,900,670);
     //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
     primaryStage.setScene(scene);
     primaryStage.show();
 }
    public void DoctorLoginPress(MouseEvent event) throws Exception
    {

        ((Node)event.getSource()).getScene().getWindow().hide(); // to hide previous window

        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("DoctorLogin.fxml"));

        Scene scene = new Scene(root,900,670);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void PatientLoginPress(MouseEvent event) throws Exception {
        ((Node)event.getSource()).getScene().getWindow().hide(); // to hide previous window

        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("PatientWork.fxml"));

        Scene scene = new Scene(root,1300,680);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Media media = new Media("file:///F:/JavaProjects/breastCancerDetection/src/Resources/video.mp4");
        MediaPlayer player = new MediaPlayer(media);
        mediaView.setMediaPlayer(player);
        player.setVolume(0);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();
    }
}
