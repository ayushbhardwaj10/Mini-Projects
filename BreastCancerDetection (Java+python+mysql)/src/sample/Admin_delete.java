package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Admin_delete {

    @FXML
    private Label lbl;

    @FXML
    private TextField pid;

    private int PID;

    public void delete() throws Exception
    {
      PID= Integer.parseInt(pid.getText());

        String query = "delete from patients where patientID= ?;";

        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:sqlite:doctorsDB.sqlite");

        // Statement statement = conn.createStatement();

        PreparedStatement preparedStatement = null;
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, Integer.toString(PID));


        int b= preparedStatement.executeUpdate();

          if(b>0)
         {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("STATUS");
            window.setMinWidth(250);
            window.setMinHeight(150);

            Label lbl = new Label();
            lbl.setText("Values Deleted Successfully");
            Button closeButton = new Button("Close");
            closeButton.setOnAction(e->window.close());

            VBox layout = new VBox(10);
            layout.getChildren().addAll(lbl,closeButton);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout);
            window.setScene(scene);
            window.showAndWait();
          }
          else {

             lbl.setText("OOps..Deletion Unsuccessful..!!");
          }


    }

    public void returnHome(MouseEvent event) throws Exception {
        ((Node) event.getSource()).getScene().getWindow().hide(); // to hide previous window

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AdminWork.fxml"));
        Scene scene = new Scene(root, 1300, 680);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
