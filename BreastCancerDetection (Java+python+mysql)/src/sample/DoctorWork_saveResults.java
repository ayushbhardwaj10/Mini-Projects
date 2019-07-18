package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DoctorWork_saveResults {

    @FXML
    private TextField patientID1;

    @FXML
    private TextField cancerLevel;

    @FXML
    private Label status ;

    public void save() throws Exception{
        String s1= patientID1.getText();
        String s2= cancerLevel.getText();
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:doctorsDB.sqlite");

        String query = "update patients set Cancer_Level=? where patientID=?;";
        PreparedStatement preparedStatement = null ;
        preparedStatement= conn.prepareStatement(query);
        preparedStatement.setString(1,s2 );
        preparedStatement.setString(2,s1);
        int x = preparedStatement.executeUpdate();
        if(x>0) {
            status.setText("Inserted Successfully");
        }
        else {
            status.setText("Sorry Failed..!!");
        }

    }
}
