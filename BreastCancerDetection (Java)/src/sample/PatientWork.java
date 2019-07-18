package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.*;


public class PatientWork {

    @FXML
    private Label result;

    @FXML
    private TextField id;

    public void chatbotOpen(MouseEvent event)  {

      ChatBot chatbot = new ChatBot();
    }

    public void checkCancerLevel() throws Exception {
     int patID= Integer.parseInt(id.getText());

        Class.forName("org.sqlite.JDBC");

        Connection conn = DriverManager.getConnection("jdbc:sqlite:doctorsDB.sqlite");

        String query = "select * from patients where patientID = ?;";
        PreparedStatement preparedStatement = null ;
        preparedStatement= conn.prepareStatement(query);
        preparedStatement.setString(1, Integer.toString(patID));
        ResultSet resultset= preparedStatement.executeQuery() ;
        if(!resultset.next()){
            result.setText("Sorry, Not found");
        }
        resultset= preparedStatement.executeQuery() ;
        if(resultset.next()) {
            if(resultset.getInt("Cancer_Level")==2)
                result.setText("Unhealthy");
            else result.setText("Healthy");
          //result.setText(Integer.toString(resultset.getInt("Cancer_Level")));
        }

    }
    public void returnHome(MouseEvent event) throws Exception {
        ((Node) event.getSource()).getScene().getWindow().hide(); // to hide previous window

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Index.fxml"));
        Scene scene = new Scene(root, 1300, 680);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
