package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;

public class Admin_Insert  {


    @FXML
    private TextField P_id;

    @FXML
    private TextField P_name;

    @FXML
    private TextField P_age;

    @FXML
    private TextField P_dob;

    @FXML
    private TextField P_email;

    @FXML
    private TextField P_phoneNo;

    @FXML
    private TextArea P_extra;

    @FXML
    private Label alert;

    private int PId,PAge;
    private long PPhoneNo;
    private String PName,PDob,PEmail,PExtra;

    public void Submit() throws Exception{

        PId= Integer.parseInt(P_id.getText());
        PAge= Integer.parseInt(P_age.getText());
        PPhoneNo= Long.parseLong(P_phoneNo.getText());

        PName = P_name.getText();
        PDob= P_dob.getText();
        PEmail=P_email.getText();
        PExtra=P_extra.getText();

        String query = "insert into patients(patientID,name,age,dob,email,phoneNo,extra_Details) values(?,?,?,?,?,?,?);";

        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:sqlite:doctorsDB.sqlite");

        // Statement statement = conn.createStatement();

        PreparedStatement preparedStatement = null;
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, Integer.toString(PId));
        preparedStatement.setString(2, PName);
        preparedStatement.setString(3, Integer.toString(PAge));
        preparedStatement.setString(4, PDob);
        preparedStatement.setString(5, PEmail);
        preparedStatement.setString(6, Long.toString(PPhoneNo));
        preparedStatement.setString(7, PExtra);

        int b= preparedStatement.executeUpdate();

        //AlertBox Display
        if(b>=0)
        {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("STATUS");
            window.setMinWidth(250);
            window.setMinHeight(150);

            Label lbl = new Label();
            lbl.setText("Values Entered Successfully");
            Button closeButton = new Button("Close");
            closeButton.setOnAction(e->window.close());

            VBox layout = new VBox(10);
            layout.getChildren().addAll(lbl,closeButton);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout);
            window.setScene(scene);
            window.showAndWait();

        }

        //To check insertion on console
        Statement statement= conn.createStatement();
        query= "Select * from patients;";
        ResultSet resultset= statement.executeQuery(query);

        while(resultset.next())
        {
            System.out.println(resultset.getInt("patientID")+" " + resultset.getString("name"));
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

